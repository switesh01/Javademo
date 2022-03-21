package com.crs.lt.application;

import java.sql.SQLException;
import java.util.Scanner;



import com.crs.lt.bean.Student;
import com.crs.lt.business.StudentInterface;
import com.crs.lt.business.StudentOperation;

public class Application {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	static Scanner sc = new Scanner(System.in);
	StudentInterface studentInterface = new StudentOperation();
	public static void main(String[] args) throws SQLException {
		getMenu();
	}
	
		public static void getMenu() throws SQLException{
		Scanner sc= new Scanner(System.in);
		int operation;
		System.out.println("CRS Application Menu:");
		System.out.println("1. Login");
		System.out.println("2. Student registration");
		System.out.println("3. exit");
		operation = sc.nextInt();
		while(operation < 4){
		switch(operation){
		case 1:
			getLoginMenu();
			break;
		case 2:
			System.out.println("Enter studentId:");
			int studentId = sc.nextInt();
			getCourseMenu(operation);
			break;
		case 3:
			return;
		default:
			System.out.println("Invalid Option");
		}
		getMenu();
		operation = sc.nextInt();
		}
	}
		
		private static void getLoginMenu() throws SQLException {
			
			System.out.println("Enter required number for role:");
			System.out.println("1.Admin Role");
			System.out.println("2.Professor Role");
			System.out.println("3.Student Role");
			int role = sc.nextInt();
			
			switch(role){
			
			case 1:
				
				break;
			case 2:
				getProfessoMenu();
				break;
				
			case 3:
				System.out.println("Enter UserId:");
				int studentId = sc.nextInt();
				getCourseMenu(studentId);
				break;
				
			case 4:
				return;
			default:
				System.out.println("Enter valid option");
			
			}
			
		}
		public static void getCourseMenu(int studentId) throws SQLException {
			CRSCourseMenu studentMenu = new CRSCourseMenu();	
			studentMenu.courseMenu(studentId);
		}
		public static void getProfessoMenu() throws SQLException {
			// TODO Auto-generated method stub
			CRSProfessorMenu professorMenu=new CRSProfessorMenu();
			professorMenu.professorMenu();
		}
		
//		public static void getStudentMenu(int studentId) throws SQLException{
////			CRSStudentMenu studentMenu = new CRSStudentMenu();	
////			studentMenu.studentMenu();
////			
////			CRSStudentMenu studentMenu=new CRSStudentMenu();
////			studentMenu.studentMenu(studentId);
//			
//			CRSCourseMenu studentMenu = new CRSCourseMenu();	
//			studentMenu.courseMenu(studentId);
//			
//		}
		
		
		public static void getAdminMenu() {
			// TODO Auto-generated method stub
			
		}


}
