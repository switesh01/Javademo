package com.lt.business;

import java.sql.SQLException;

import com.lt.exception.StudentNotRegisteredException;

/**
 * 
 * @author Group-4
 *
 */

public interface StudentInterface {
	
	
	public int register(String name,int userID,String password,int batch,String branch) throws StudentNotRegisteredException, SQLException; 
	
	public int getStudentId(int userId) throws SQLException;
	
	
    public boolean isApproved(int studentId) throws SQLException;
}
