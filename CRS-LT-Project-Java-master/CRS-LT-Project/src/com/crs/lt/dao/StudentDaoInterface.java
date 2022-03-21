/**
 * 
 */
package com.crs.lt.dao;

import java.util.List;
import java.util.Set;

import com.crs.lt.bean.Student;

/**
 * @author user218
 *
 */
public interface StudentDaoInterface {
	public void addStudent(Student student);

	public Student getStudentById(int studentId);

	public void deleteStudent(int studentId);
	
	public Student updateStudent(Student student);
	
	public Set<Student> listStudent();
}
