package com.crs.lt.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crs.lt.business.NotificationInterface;
import com.crs.lt.business.NotificationOperation;
import com.crs.lt.business.StudentInterface;
import com.crs.lt.business.StudentOperation;
import com.crs.lt.business.UserInterface;
import com.crs.lt.business.UserOperation;
import com.crs.lt.constant.NotificationType;
import com.crs.lt.constant.Role;
import com.crs.lt.exception.StudentNotRegisteredException;
import com.crs.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 * 
 */
public class CRSApplication {

	private static Logger logger = Logger.getLogger(CRSApplication.class);
	static boolean loggedin = false;
	StudentInterface studentInterface=StudentOperation.getInstance();
	UserInterface userInterface =UserOperation.getInstance();
	NotificationInterface notificationInterface=NotificationOperation.getInstance();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CRSApplication crsApplication=new CRSApplication();
		int userInput;	
		createMainMenu();
		userInput=sc.nextInt();
		try
		{
			
		while(userInput!=4)
		{
			switch(userInput)
			{	
				case 1:					
					crsApplication.loginUser();
					break;
				case 2:
					crsApplication.registerStudent();
					break;	
				case 3:
					crsApplication.updatePassword();
					break;
				default:
					logger.info("Invalid Input");
			}
			createMainMenu();
			userInput=sc.nextInt();
		}
		}
		catch(Exception ex)
		{
			logger.error("Error occured "+ex);
		}
		finally
		{
			sc.close();
		}
	}
	
	
	public static void createMainMenu()
	{
		logger.info("Course Registration System");
		logger.info("1. Login");
		logger.info("2. Student Registration");
		logger.info("3. Update password");
		logger.info("4. Exit");
		logger.info("Enter input");
	}
	
	public void loginUser()
	{

		Scanner sc=new Scanner(System.in);

		int userId;
		String password;
		try
		{
			logger.info("Login");
			logger.info("user Id:");
			userId=sc.nextInt();
			logger.info("Password:");
			password=sc.next();
			loggedin = userInterface.verifyCredentials(userId, password);
		
			if(loggedin)
			{
				 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
				 
				 LocalDateTime myDateObj = LocalDateTime.now();
				   
				 String formattedDate = myDateObj.format(myFormatObj);  

				String role=userInterface.getRole(userId);
				Role userRole=Role.stringToName(role);
				switch(userRole)
				{
				case ADMIN:
					logger.info(formattedDate + " Login Successful");
					AdminCRSMenu adminMenu=new AdminCRSMenu();
					adminMenu.createMenu();
					break;
				case PROFESSOR:
					logger.info(formattedDate + " Login Successful");
					ProfessorCRSMenu professorMenu=new ProfessorCRSMenu();
					professorMenu.createMenu(userId);
					
					break;
				case STUDENT:
					
					int studentId=studentInterface.getStudentId(userId);
					boolean isApproved=studentInterface.isApproved(studentId);
					if(isApproved)
					{
						logger.info(formattedDate + " Login Successful");
						StudentCRSMenu studentMenu=new StudentCRSMenu();
						studentMenu.create_menu(studentId);
						
					}
					else
					{
						logger.warn("Failed to login, you have not been approved by the administration!");
						loggedin=false;
					}
					break;
				}
				
				
			}
			else
			{
				logger.error("Invalid Credentials!");
			}
			
		}
		catch(UserNotFoundException ex)
		{
			logger.error(ex.getMessage());
		}	
	}
	

	public void registerStudent()
	{
		Scanner sc=new Scanner(System.in);

		int userId;
		String name,password,branchName;
		
		int  batch;
		try
		{
			
			logger.info("Student Registration-----");
			logger.info("Name:");
			name=sc.nextLine();
			logger.info("userId:");
			userId=sc.nextInt();
			logger.info("Password:");
			password=sc.next();
			
			sc.nextLine();
			logger.info("Branch:");
			branchName=sc.nextLine();
			logger.info("Batch:");
			batch=sc.nextInt();
			sc.nextLine();
			int newStudentId=studentInterface.register(name, userId, password,  batch, branchName);
			//notificationInterface.sendNotification(NotificationType.REGISTRATION, newStudentId, null,0);
			
		}
		catch(StudentNotRegisteredException ex)
		{
			logger.error("Error "+ex.getStudentName() +" not registered.");
		}
	}

	public void updatePassword()
	{
		Scanner sc=new Scanner(System.in);
		String userId,newPassword;
		try
		{
			logger.info("Update Password");
			logger.info("Email");
			userId=sc.next();
			logger.info("New Password:");
			newPassword=sc.next();
			boolean isUpdated=userInterface.updatePassword(userId, newPassword);
			if(isUpdated)
				logger.info("Password updated successfully!");

			else
				logger.error("Something went wrong, please try again!");
		}
		catch(Exception ex)
		{
			logger.error("Error Occured "+ex.getMessage());
		}
	}
}
