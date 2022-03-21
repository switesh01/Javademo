package com.lt.crs.exception;

/**
 * Exception to check if user cannot be added
 * @author Group-4
 *
 */
public class UserNotAddedException extends Exception{
	private int userId;
	
	public UserNotAddedException(int userId) {
		this.userId = userId;
	}
	
	/**
	 * Getter function for UserId
	 * @return
	 */
	public int getUserId() {
		return this.userId;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "UserId: " + userId + " is already in use!";
	}
}
