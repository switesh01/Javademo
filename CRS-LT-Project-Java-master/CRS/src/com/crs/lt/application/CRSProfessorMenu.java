package com.crs.lt.application;

import java.sql.SQLException;
import java.util.Scanner;

import com.crs.lt.bean.Professor;
import com.crs.lt.business.ProfessorInterface;
import com.crs.lt.business.ProfessorOperation;

public class CRSProfessorMenu {

	ProfessorInterface professorOperation=new ProfessorOperation();

	public void professorMenu() throws SQLException {
		int operation;
		Scanner sc = new Scanner(System.in);
		System.out.println("CRS Professor Menu:");
		System.out.println("1.Add Prof");
		System.out.println("2.Add Grade");
		System.out.println("3.View Courses by Prof");
		System.out.println("4.View all Profs");
		System.out.println("5.Exit");

		operation = sc.nextInt();
		switch (operation) {
		case 1:
			addProfessor();
			professorMenu();
			break;
		case 2:
			addGrade();
			professorMenu();
			break;
		case 3:
			viewCoursesByProfessor();
			professorMenu();
			break;
		case 4:
			viewAllProfessors();
			professorMenu();
			break;
		case 5:
			return;
		default:
			System.out.println("Invalid Option");
		}

	}

	private void addProfessor() throws SQLException {
		Professor professor=new Professor();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter professor id:");
		professor.setProfessorId(sc.nextInt());
		System.out.println("enter dept:");
		sc.nextLine();
		professor.setDepartment(sc.nextLine());
		System.out.println("enter designation:");
		professor.setDesignation(sc.nextLine());
		System.out.println(professor.toString());
		professorOperation.addProfessor(professor);
	}

	private void addGrade() throws SQLException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter student id:");
		int studentId=sc.nextInt();
		System.out.println("enter course id:");
		String courseCode=sc.nextLine();
		System.out.println("enter grade:");
		String grade=sc.nextLine();
		professorOperation.addrGrade(studentId, courseCode, grade);
	}

	private void viewCoursesByProfessor() throws SQLException {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter professor id:");
		professorOperation.getProfessorById(sc.nextInt());
	}

	private void viewAllProfessors() throws SQLException {
		System.out.println(professorOperation.viewAllProfessors());
	}
}
