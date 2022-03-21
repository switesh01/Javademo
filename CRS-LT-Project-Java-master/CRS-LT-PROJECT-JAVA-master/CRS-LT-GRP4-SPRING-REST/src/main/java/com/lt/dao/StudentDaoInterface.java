/**
 * 
 */
package com.lt.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.lt.bean.Student;
import com.lt.exception.StudentNotRegisteredException;

/**
 * 
 * @author Group-4
 * Interface for Student Operations
 *
 */
@Repository
public interface StudentDaoInterface {
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 * @throws SQLException 
	 */
	public int addStudent(Student student) throws StudentNotRegisteredException, SQLException;
	
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 * @throws SQLException 
	 */
	public int getStudentId(int userId) throws SQLException;
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 * @throws SQLException 
	 */
	public boolean isApproved(int studentId) throws SQLException;
}
