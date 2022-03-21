package com.lt.business;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.dao.UserDaoInterface;
import com.lt.dao.UserDaoOperation;
import com.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 *
 */
@Service
public class UserOperation implements UserInterface {
	
	private static UserOperation instance=null;
	
	@Autowired
	UserDaoInterface userDaoInterface;
	
	private static Logger logger = Logger.getLogger(UserOperation.class);
	
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
	public boolean updatePassword(int userID,String newPassword) throws SQLException {
		return userDaoInterface.updatePassword(userID, newPassword);
	}

	
	
	@Override
	public boolean verifyCredentials(int userID, String password) throws UserNotFoundException, SQLException {
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
	public String getRole(int userId) throws SQLException {
		logger.debug("service: "+userDaoInterface.getRole(userId));
		return userDaoInterface.getRole(userId);
	}

}
