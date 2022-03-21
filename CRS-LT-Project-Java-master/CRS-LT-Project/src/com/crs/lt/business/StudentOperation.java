package com.crs.lt.business;

import java.util.Set;

import com.crs.lt.bean.GradeCard;
import com.crs.lt.bean.Student;
import com.crs.lt.dao.StudentDaoImpl;
import com.crs.lt.dao.StudentDaoInterface;

public class StudentOperation implements StudentInterface{

	StudentDaoInterface studentDaoInterface = new StudentDaoImpl();;
	
	public void register(Student student) {
		
		Student student1 = new Student();
		student1.setName(student.getName());
		student1.setBranchName(student.getBranchName());
		student1.setBatch(student.getBatch());
		student1.setRole("STUDENT");
		student1.setGradeCard(null);
		studentDaoInterface.addStudent(student1);
	}

	public GradeCard viewGradeCard(int studentId) {		
		return studentDaoInterface.getStudentById(studentId).getGradeCard();
	
	}

	public Student getStudentById(int studentId) {
		return studentDaoInterface.getStudentById(studentId);
	}

	public void deleteStudent(int studentId) {
		studentDaoInterface.deleteStudent(studentId);
		System.out.println("Student Deleted scuccessfully");
	}

	public Student updateStudent(Student student) {
		System.out.println("Student Id:"+student.getStudentId() +" "+ student.getName() +" "+ student.getRole()
				+" "+ student.getBatch() +" "+ student.getBranchName());
		return studentDaoInterface.updateStudent(student);
		
	}

	public Set<Student> listStudent() {
		return studentDaoInterface.listStudent();
	}


}
