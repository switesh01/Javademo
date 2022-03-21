/**
 * 
 */
package com.crs.lt.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.crs.lt.bean.Student;

/**
 * @author user218
 *
 */
public class StudentDaoImpl implements StudentDaoInterface{
	//List<Student> studentList = new ArrayList<Student>();	
	Set<Student> studentSet = new HashSet<Student>();
	private static int count = 0;
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		student.setStudentId(++count);
		studentSet.add(student);
		
	}

	public Student getStudentById(int studentId) {
		Iterator itr = studentSet.iterator();
		while (itr.hasNext()) {
			Student student = (Student) itr.next();
			if (student.getStudentId() == studentId) {
				return student;
			}
		}
		return null;
	}

	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		Iterator itr = studentSet.iterator();
		while (itr.hasNext()) {
			System.out.println("inside while:::");
			Student student = (Student) itr.next();
			System.out.println("in dao studentId:: "+studentId);
			System.out.println("indao "+student.toString());
			if (student.getStudentId() == studentId) {
				System.out.println("inside if:::");
				studentSet.remove(student);
				return;
			}
		}
	}

	public Student updateStudent(Student student) {
		
		Iterator<Student> itr = studentSet.iterator();
		while (itr.hasNext()) {
			System.out.println("inside while:::");
			System.out.println("while student Id:::"+student.getStudentId());	
			System.out.println("itr next"+itr.next().getStudentId());
			Student student1 =  itr.next();
			if (student1.getStudentId() == student.getStudentId()) {	
				System.out.println("inside if:::");
				
				student1.setBatch(student.getBatch());
				student1.setBranchName(student.getBranchName());
				student1.setName(student.getName());
				System.out.println("student1" +student1.toString());
				return student1;
			}
			System.out.println("outside if::");
		}
//		for(Student student1: studentSet){
//			if (student1.getStudentId() == student.getStudentId()) {
//				student1.setBatch(student.getBatch());
//				student1.setBranchName(student.getBranchName());
//				student1.setName(student.getName());
//				return student1;
//			}
//		}
		return null;
	}

	public Set<Student> listStudent() {

		return studentSet;
	}

}
