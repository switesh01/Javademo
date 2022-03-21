package com.crs.lt.business;

import com.crs.lt.exception.StudentNotRegisteredException;

/**
 * 
 * @author Group-4
 *
 */
public interface StudentInterface {
	
	
	public int register(String name,int userID,String password,int batch,String branch) throws StudentNotRegisteredException; 
	
	public int getStudentId(int userId);
	
	
    public boolean isApproved(int studentId);
}
