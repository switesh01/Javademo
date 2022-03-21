package com.crs.lt.application;

import java.util.Scanner;

import com.crs.lt.business.RegistrationCourseInterface;
import com.crs.lt.business.RegistrationCourseOperation;
import com.crs.lt.business.StudentInterface;
import com.crs.lt.business.StudentOperation;

public class CRSCourse {

	RegistrationCourseInterface course = new RegistrationCourseOperation();
	public void courseMenu(){
	int operation;
	Scanner sc = new Scanner(System.in);	
	System.out.println("CRS Student Menu:");
	System.out.println("1.Add Course");
	System.out.println("2.Drop Course");
	System.out.println("3.Update Course");
	System.out.println("4.Display Course");
	System.out.println("5.Exit");

	operation = sc.nextInt();
	switch(operation){
	case 1:
		addCourse();
		courseMenu();
		break;
	case 2:
		deleteStudent();
		courseMenu();
		break;
	case 3:
		updateStudent();
		courseMenu();
		break;
	case 4:
		displayStudent();
		courseMenu();
		break;
	case 5:
		return;
	default:
		System.out.println("Invalid Option");
	}
	
	}
}
