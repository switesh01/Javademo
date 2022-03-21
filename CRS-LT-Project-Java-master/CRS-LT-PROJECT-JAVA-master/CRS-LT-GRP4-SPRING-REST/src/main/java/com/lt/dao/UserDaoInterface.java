package com.lt.dao;

import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 * Interface for User Dao Operations
 *
 */
@Repository
public interface UserDaoInterface {
	
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userId
	 * @param password
	 * @return Verify credentials operation status
	 * @throws UserNotFoundException
	 * @throws SQLException 
	 */
	public boolean verifyCredentials(int userId,String password) throws UserNotFoundException, SQLException;
	
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
	 * @throws SQLException 
	 */
	public String getRole(int userId) throws SQLException;
	
	
	/**
	 * Method to update password of user in DataBase
	 * @param userID
	 * @param newPassword
	 * @return Update Password operation Status
	 * @throws SQLException 
	 */
	public boolean updatePassword(String userID,String newPassword) throws SQLException;
}
