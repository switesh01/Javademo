/**
 * 
 */
package com.crs.lt.dao;

import java.sql.SQLException;

import com.crs.lt.bean.Student;
import com.crs.lt.exception.StudentNotRegisteredException;

/**
 * 
 * @author Group-4
 * Interface for Student Operations
 *
 */
public interface StudentDaoInterface {
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 */
	public int addStudent(Student student) throws StudentNotRegisteredException;
	
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 */
	public int getStudentId(int userId);
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */
	public boolean isApproved(int studentId);
}
