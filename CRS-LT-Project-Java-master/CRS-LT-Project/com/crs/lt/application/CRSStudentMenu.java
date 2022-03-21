package com.crs.lt.application;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import com.crs.lt.bean.Student;
import com.crs.lt.business.StudentInterface;
import com.crs.lt.business.StudentOperation;

public class CRSStudentMenu {

	StudentInterface student = new StudentOperation();
	public void studentMenu(){
	int operation;
	Scanner sc = new Scanner(System.in);	
	System.out.println("CRS Student Menu:");
	System.out.println("1.Register Student");
	System.out.println("2.Delete Student");
	System.out.println("3.Update Student");
	System.out.println("4. Display Student");
	System.out.println("5. Display Student By ID");
	System.out.println("6. Display Student Grade Card");
	System.out.println("7.Exit");
	operation = sc.nextInt();
	switch(operation){
	case 1:
		registerStudent();
		studentMenu();
		break;
	case 2:
		deleteStudent();
		studentMenu();
		break;
	case 3:
		updateStudent();
		studentMenu();
		break;
	case 4:
		displayStudent();
		studentMenu();
		break;
	case 5:
		getStudentById();
		studentMenu();
		break;
	case 6:
		viewGradeCard();
		studentMenu();
		break;
	case 7:
		return;
	default:
		System.out.println("Invalid Option");
	}
	
	}

	private void viewGradeCard() {
		// TODO Auto-generated method stub
		
	}

	public void getStudentById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id:");
		int studentId = sc.nextInt();
		Student student1  = student.getStudentById(studentId);
		System.out.println(student1.toString());
		
	}

	public void displayStudent() {
		Set<Student> set = student.listStudent();
		Iterator<Student> itr = set.iterator();
		
		while (itr.hasNext()) {
			Student st = itr.next();
			System.out.println("Student Id:"+st.getStudentId() +" "+ st.getName() +" "+ st.getRole()
					+" "+ st.getBatch() +" "+ st.getBranchName());

		}
		
	}

	public void updateStudent() {
		Student student1 = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id:");
		int studentId = sc.nextInt();
		student1.setStudentId(studentId);
		System.out.println("Enter Student Name:");
		//sc.nextLine();
		String name = sc.nextLine();
		student1.setName("abc");
		System.out.println("Enter Branch Name:");
		//sc.nextLine();
		String branchName = sc.nextLine();
		student1.setBranchName(branchName);
		System.out.println("Enter Batch:");
	//	sc.nextLine();
		int batch = sc.nextInt();
		student1.setBatch(batch);
		student.updateStudent(student1);
		
	}

	public void deleteStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Id:");
		int studentId = sc.nextInt();
		student.deleteStudent(studentId);

	}

	public void registerStudent() {
	
		Student student1 = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student Name:");
		//sc.nextLine();
		String name = sc.nextLine();
		student1.setName(name);
		System.out.println("Enter Branch Name:");
		String branchName = sc.nextLine();
		student1.setBranchName(branchName);
		System.out.println("Enter Batch:");
		int batch = sc.nextInt();
		student1.setBatch(batch);
		student.register(student1);
		
	}
}
