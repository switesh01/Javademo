package com.lt.dao;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lt.bean.User;
import com.lt.constant.SQLQueriesConstants;
import com.lt.exception.UserNotFoundException;
import com.lt.mapper.UserMapper;
import com.lt.mapper.UserMapperForRole;

/**
 * 
 * @author Group-4 Class to implement User Dao Operations
 */

@Repository
public class UserDaoOperation implements UserDaoInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * Method to update password of user in DataBase
	 * 
	 * @param userID
	 * @param newPassword
	 * @return Update Password operation Status
	 * @throws SQLException
	 */
	@Override
	public boolean updatePassword(int userId, String newPassword) {
		int row = jdbcTemplate.update(SQLQueriesConstants.UPDATE_PASSWORD, newPassword, userId);
		if (row == 1)
			return true;
		else
			return false;
	}

	/**
	 * Method to verify credentials of Users from DataBase
	 * 
	 * @param userId
	 * @param password
	 * @return Verify credentials operation status
	 * @throws UserNotFoundException
	 * @throws SQLException
	 */
	@Override
	public boolean verifyCredentials(int userId, String password) throws UserNotFoundException {
		User student = jdbcTemplate.queryForObject(SQLQueriesConstants.VERIFY_CREDENTIALS, new Object[]{userId}, new UserMapper());
		if(password.equals(student.getPassword()))
			return true;
		return false;
	}

	/**
	 * Method to get Role of User from DataBase
	 * 
	 * @param userId
	 * @return Role
	 * @throws SQLException
	 */
	@Override
	public String getRole(int userId) throws SQLException {
		System.out.println(("dao: "+userId));
		String role=jdbcTemplate.queryForObject(SQLQueriesConstants.GET_ROLE, new Object[]{userId}, new UserMapperForRole());
		return role;
	}
}
