package com.lt.crs.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.lt.crs.exception.UserNotFoundException;
import com.lt.crs.model.User;

/**
 * 
 * @author Group-4
 *
 */

public interface UserInterface {
	
    int register(User user);
	
	boolean updatePassword(int userID, String newPassword);
	
	
	public boolean verifyCredentials(int userID,String password) throws UserNotFoundException;
	
	
    public String getRole(int userId);
   
 
}
