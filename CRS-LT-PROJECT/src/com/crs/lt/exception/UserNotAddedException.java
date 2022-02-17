package com.crs.lt.exception;

public class UserNotAddedException extends Exception{
	
private String userId;
	
	public UserNotAddedException(String userId) {
		this.userId = userId;
	}
	

	public String getUserId() {
		return this.userId;
	}
	

	
	public String getMessage() {
		return "UserId: " + userId + " is already in use!";
	}

}
