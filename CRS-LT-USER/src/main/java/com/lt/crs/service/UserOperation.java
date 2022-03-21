package com.lt.crs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.crs.exception.StudentNotRegisteredException;
import com.lt.crs.exception.UserNotFoundException;
import com.lt.crs.model.Student;
import com.lt.crs.model.User;
import com.lt.crs.repository.UserRepository;

/**
 * 
 * @author Group-4
 *
 */
@Service
@Transactional
public class UserOperation implements UserInterface {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public int register(User user) {
		System.out.println(user.toString());
		User newUser=userRepository.save(user);
		return newUser.getUserId();
	}
	
	@Override
	public boolean updatePassword(int userId,String newPassword) {
		System.out.println("service: "+userId+newPassword);
		userRepository.updatePassword(userId, newPassword);
		return true;
	}
	
	
	@Override
	public boolean verifyCredentials(int userID, String password) throws UserNotFoundException {
		System.out.println("service");
		System.out.println("userId:"+userID);
		System.out.println("password:"+password);
		System.out.println(userRepository.verifyCredentials(userID));
		if((userRepository.verifyCredentials(userID)).equals(password))
			return true;
		return false;
	}
	
	
	@Override
	public String getRole(int userId) {
		return userRepository.getRole(userId);
	}

}
