package com.crs.lt.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.EnrolledStudent;
import com.crs.lt.business.ProfessorInterface;
import com.crs.lt.business.ProfessorOperation;
import com.crs.lt.exception.GradeNotAddedException;


/**
 * 
 * @author Group-4
 * 
 */
public class ProfessorCRSMenu {

	
	private static Logger logger = Logger.getLogger(ProfessorCRSMenu.class);
	ProfessorInterface professorInterface=ProfessorOperation.getInstance();

	public void createMenu(int userId)
	{
		
		Scanner sc=new Scanner(System.in);
		
		int input;
		while(CRSApplication.loggedin)
		{

			logger.info("Professor Menu");
			logger.info("1. View Courses");
			logger.info("2. View Enrolled Students");
			logger.info("3. Add grade");
			logger.info("4. Logout");
		
			
			//input user
			input=sc.nextInt();
			switch(input)
			{
				case 1:
				
					getCourses(userId);
					break;
				case 2:
					
					viewEnrolledStudents(userId);
					break;
					
				case 3:
					
					addGrade(userId);
					break;
				case 4:
				
					CRSApplication.loggedin=false;
					return;
				default:
					logger.error("Invalid option");
			}
		}
		
		
	}
	

	public void viewEnrolledStudents(int profId)
	{
		List<Course> coursesEnrolled=professorInterface.getCourses(profId);
		logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE CODE","Students  enrolled" ));
		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorInterface.viewEnrolledStudents(profId);
			for(EnrolledStudent obj: enrolledStudents)
			{
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			
		}
		catch(Exception ex)
		{
			logger.error(ex.getMessage()+"Error");
		}
	}


	public void getCourses(int userId)
	{
		try
		{
			List<Course> coursesEnrolled=professorInterface.getCourses(userId);
			logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","No. of Students  enrolled" ));
			for(Course obj: coursesEnrolled)
			{
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),10- obj.getSeats()));
			}		
		}
		catch(Exception ex)
		{
			logger.error("Error"+ex.getMessage());
		}
	}
	

	public void addGrade(int profId)
	{	
		Scanner sc=new Scanner(System.in);
		
		int studentId;
		String courseCode,grade;
		try
		{
			List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
			enrolledStudents=professorInterface.viewEnrolledStudents(profId);
			logger.info(String.format("%20s %20s %20s","COURSE CODE","COURSE NAME","Student ID" ));
			for(EnrolledStudent obj: enrolledStudents)
			{
				logger.info(String.format("%20s %20s %20s",obj.getCourseCode(), obj.getCourseName(),obj.getStudentId()));
			}
			List<Course> coursesEnrolled=new ArrayList<Course>();
			coursesEnrolled	=professorInterface.getCourses(profId);
			logger.info("Add Grade");
			logger.info("Enter student id");
			studentId=sc.nextInt();
			logger.info("Enter course code");
			courseCode=sc.next();
			logger.info("Enter grade");
			grade=sc.next();
			//if(ProfessorValidator.isValidStudent(enrolledStudents, studentId) && ProfessorValidator.isValidCourse(coursesEnrolled, courseCode))
			//{
				professorInterface.addGrade(studentId, courseCode, grade);
				logger.info("Grade added successfully for "+studentId);
			//}
			//else
			//{
				//logger.info("Invalid data entered, try again!");
			//}
		}
		catch(GradeNotAddedException ex)
		{
			logger.error("Grade cannot be added for"+ex.getStudentId());
			
		}
		catch(SQLException ex)
		{
			logger.error("Grade not added,error occured "+ex.getMessage());
		}
	
	}
}
