/**
 * 
 */
package com.lt.crs.exception;

/**
 * Exception to check if user exists 
 * @author Group-4
 *
 */
public class UserNotFoundException extends Exception {

	private int userId;

	
	public UserNotFoundException(int userId) {
		this.userId = userId;
	}

	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() {
		return "User with userId: " + userId + " not found.";
	}

}
