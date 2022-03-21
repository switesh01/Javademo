package com.lt.business;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 *
 */

public interface UserInterface {
	
	
	boolean updatePassword(String userID, String newPassword) throws SQLException;
	
	
	public boolean verifyCredentials(int userID,String password) throws UserNotFoundException, SQLException;
	
	
    public String getRole(int userId) throws SQLException;
   
 
}
