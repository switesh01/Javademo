package com.crs.lt.application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Student;
import com.crs.lt.business.RegistrationCourseInterface;
import com.crs.lt.business.RegistrationCourseOperation;
import com.crs.lt.business.StudentInterface;
import com.crs.lt.business.StudentOperation;

public class CRSCourseMenu {

	RegistrationCourseInterface course = new RegistrationCourseOperation();

	public void courseMenu(int studentId) throws SQLException {
		int operation;
		Scanner sc = new Scanner(System.in);
		System.out.println("CRS Student Menu:");
		System.out.println("1.Register Course");
		System.out.println("2.Add Course");
		System.out.println("3.Drop Course");
		System.out.println("4.Update Course");
		System.out.println("5.Display Course");
		System.out.println("6.view registered course");
		System.out.println("7.view Gradecard");
		System.out.println("8.Make payment");
		System.out.println("9.Exit");

		operation = sc.nextInt();
		switch (operation) {
		case 1:
			registerCourse(studentId);

			break;
		case 2:
			addCourse();

			break;
		case 3:
			deleteCourse();

			break;
		case 4:
			updateCourse();

			break;
		case 5:
			viewCourse();

			break;
		case 6:
			viewRegisteredCourse();

			break;
		case 7:
			viewGradeCard();

			break;
		case 8:
			makePayment();

			break;
		case 9:
			return;
		default:
			System.out.println("Invalid Option");
		}

	}

	private void makePayment() {
		// TODO Auto-generated method stub
		
	}

	private void viewGradeCard() {
		// TODO Auto-generated method stub
		
	}

	private void viewRegisteredCourse() {
		// TODO Auto-generated method stub
		
	}

	private void registerCourse(int studentId) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Student student = new Student();
		System.out.println("Enter Student Id:");
		int studentId1 = sc.nextInt();
		List<Course> courseList = course.viewCourse();
		System.out.println("Enter Course code:");
		String courseCode = sc.nextLine();
		
		
	}

	private void addCourse() throws SQLException {
		Course course1 = new Course();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Code:");
		String courseCode = sc.nextLine();
		course1.setCourseCode(courseCode);
		System.out.println("Enter Course Name:");
		String courseName = sc.nextLine();
		course1.setCourseName(courseName);
		System.out.println("Enter catalog Id:");
		int catalogId = sc.nextInt();
		course1.setCatalogId(catalogId);
		System.out.println("Enter seats");
		int seats = sc.nextInt();
		course1.setSeats(seats);
		System.out.println("Enter Course Fee:");
		float courseFee = sc.nextFloat();
		course1.setCourseFee(courseFee);
		System.out.println("Enter Professor Id:");
		int professorId = sc.nextInt();
		course1.setProfessorId(professorId);
		course.addCourse(course1);
		
	}

	private void viewCourse() throws SQLException {
		List<Course> courseList = course.viewCourse();
		for (Course course : courseList) {
			System.out.println("Course Code:" + course.getCourseCode()
					+ "Course Name:" + course.getCourseName()
					+ "Course catalog Id:" + course.getCatalogId() + "Seats:"
					+ course.getSeats() + "course Fee:" + course.getCourseFee()
					+ "professor:" + course.getProfessorId());
			
		}
	}

	private void updateCourse() throws SQLException {
		Course course1 = new Course();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Course Code:");
		String courseCode = sc.nextLine();
		course1.setCourseCode(courseCode);
		System.out.println("Enter Course Name:");
		String courseName = sc.nextLine();
		course1.setCourseName(courseName);
		System.out.println("Enter Course Fee:");
		float courseFee = sc.nextFloat();
		course1.setCourseFee(courseFee);	
		course.updateCourse(courseCode, courseName, courseFee);

	}

	private void deleteCourse() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter course code:");
		String courseCode = sc.nextLine();
		course.deleteCourse(courseCode);

	}

}
