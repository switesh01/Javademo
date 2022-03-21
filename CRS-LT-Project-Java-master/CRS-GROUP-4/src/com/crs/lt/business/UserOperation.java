package com.crs.lt.business;

import com.crs.lt.dao.UserDaoInterface;
import com.crs.lt.dao.UserDaoOperation;
import com.crs.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 *
 */
public class UserOperation implements UserInterface {
	
	private static volatile UserOperation instance=null;
	UserDaoInterface userDaoInterface= UserDaoOperation.getInstance();
	private UserOperation()
	{
		
	}
	
	
	public static UserOperation getInstance()
	{
		if(instance==null)
		{
			
			synchronized(UserOperation.class){
				instance=new UserOperation();
			}
		}
		return instance;
	}

	
	@Override
	public boolean updatePassword(String userID,String newPassword) {
		return userDaoInterface.updatePassword(userID, newPassword);
	}

	
	
	@Override
	public boolean verifyCredentials(int userID, String password) throws UserNotFoundException {
		//DAO class
		try
		{
			return userDaoInterface.verifyCredentials(userID, password);		
		}
		finally
		{
			
		}
	}
	
	
	@Override
	public String getRole(int userId) {
		return userDaoInterface.getRole(userId);
	}


	

}
