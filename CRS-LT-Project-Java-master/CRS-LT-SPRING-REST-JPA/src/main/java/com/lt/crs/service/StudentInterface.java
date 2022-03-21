package com.lt.crs.service;

import java.sql.SQLException;

import com.lt.crs.exception.StudentNotRegisteredException;
import com.lt.crs.model.Student;

/**
 * 
 * @author Group-4
 *
 */

public interface StudentInterface {
	
	public int register(Student student) throws StudentNotRegisteredException; 
	
	public Student getStudentById(int userId);
	
    public boolean isApproved(int studentId);
}
