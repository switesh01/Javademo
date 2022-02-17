package com.crs.lt.exception;

public class UserNotFoundException extends Exception{

	
	private String userId;

	/***
	 * Getter function for UserId
	 * @param userId
	 */
	public UserNotFoundException(String userId) {
		this.userId = userId;
	}

	
	public String getMessage() {
		return "User with userId: " + userId + " not found.";
	}
}
