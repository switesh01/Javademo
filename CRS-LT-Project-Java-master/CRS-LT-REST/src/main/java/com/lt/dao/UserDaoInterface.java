package com.crs.lt.dao;

import com.crs.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 * Interface for User Dao Operations
 *
 */
public interface UserDaoInterface {
	
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userId
	 * @param password
	 * @return Verify credentials operation status
	 * @throws UserNotFoundException
	 */
	public boolean verifyCredentials(int userId,String password) throws UserNotFoundException;
	
	/**
	 * Method to update password of user in DataBase
	 * @param userID
	 * @return Update Password operation Status
	 */
	//TODO Duplicate Function. Please remove it if its not necessary
	public boolean updatePassword(String userID);
	
	/**
	 * Method to get Role of User from DataBase
	 * @param userId
	 * @return Role
	 */
	public String getRole(int userId);
	
	
	/**
	 * Method to update password of user in DataBase
	 * @param userID
	 * @param newPassword
	 * @return Update Password operation Status
	 */
	public boolean updatePassword(String userID,String newPassword);
}
