package com.crs.lt.business;

import com.crs.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 *
 */
public interface UserInterface {
	
	
	boolean updatePassword(String userID, String newPassword);
	
	
	public boolean verifyCredentials(int userID,String password) throws UserNotFoundException;
	
	
    public String getRole(int userId);
   
 
}
