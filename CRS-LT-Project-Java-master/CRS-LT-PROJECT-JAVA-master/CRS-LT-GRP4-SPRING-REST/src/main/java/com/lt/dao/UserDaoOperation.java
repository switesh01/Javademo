package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lt.configuration.ConfigurationJDBC;
import com.lt.constant.SQLQueriesConstants;
import com.lt.exception.UserNotFoundException;


/**
 * 
 * @author Group-4
 * Class to implement User Dao Operations
 */

public class UserDaoOperation implements UserDaoInterface{
	@Autowired
	   private ConfigurationJDBC configurationJdbc;
	private static  UserDaoOperation instance=null;
	private static Logger logger = Logger.getLogger(UserDaoOperation.class);
	
	/**
	 * Default Constructor
	 */
	private UserDaoOperation()
	{
		
	}
	
	/**
	 * Method to make UserDaoOperation Singleton
	 * @return
	 */
	public static UserDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(UserDaoOperation.class){
				instance=new UserDaoOperation();
			}
		}
		return instance;
	}

	/**
	 * Method to update password of user in DataBase
	 * @param userID
	 * @param newPassword
	 * @return Update Password operation Status
	 * @throws SQLException 
	 */
	@Override
	public boolean updatePassword(String userId, String newPassword) throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.UPDATE_PASSWORD);
			
			statement.setString(1, newPassword);
			statement.setString(2, userId);
			
			int row = statement.executeUpdate();
			
			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userId
	 * @param password
	 * @return Verify credentials operation status
	 * @throws UserNotFoundException
	 * @throws SQLException 
	 */
	@Override
	public boolean verifyCredentials(int userId, String password) throws UserNotFoundException, SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		try
		{
			//open db connection
			PreparedStatement preparedStatement=connection.prepareStatement(SQLQueriesConstants.VERIFY_CREDENTIALS);
			//System.out.println("userId in"+userId);
			preparedStatement.setInt(1,userId);
			//System.out.println("userId out"+userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next())
				throw new UserNotFoundException(userId);
			else if(password.equals(resultSet.getString("password")))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}
		catch(SQLException ex)
		{
			logger.info("Something went wrong, please try again! "+ ex.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * Method to update password of user in DataBase
	 * @param userID
	 * @return Update Password operation Status
	 */
	@Override
	public boolean updatePassword(String userID) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Method to get Role of User from DataBase
	 * @param userId
	 * @return Role
	 * @throws SQLException 
	 */
	@Override
	public String getRole(int userId) throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_ROLE);
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getString("role");
			}
				
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	
}
