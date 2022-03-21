package com.lt.crs.repository;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.crs.constant.Role;
import com.lt.crs.exception.UserNotFoundException;
import com.lt.crs.model.User;

/**
 * 
 * @author Group-4
 * Interface for User Dao Operations
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	/**
	 * Method to verify credentials of Users from DataBase
	 * @param userId
	 * @param password
	 * @return Verify credentials operation status
	 * @throws UserNotFoundException
	 */
	@Query("select u.password from User u where u.userId = :userId")
	public String verifyCredentials(@Param("userId") int userId) throws UserNotFoundException;
	
	
	/**
	 * Method to get Role of User from DataBase
	 * @param userId
	 * @return Role
	 * @throws SQLException 
	 */
	@Query("select u.role from User u where u.userId = :userId")
	public String getRole(@Param("userId") int userId);
	
	
	/**
	 * Method to update password of user in DataBase
	 * @param userID
	 * @param newPassword
	 * @return Update Password operation Status
	 * @throws SQLException 
	 */
	@Modifying
	@Query(value = "update user set password = :newPassword where user_id = :userId", nativeQuery = true)
	public void updatePassword(@Param("userId") int userId,@Param("newPassword") String newPassword);
}
