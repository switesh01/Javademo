/**
 * 
 */
package com.lt.crs.exception;

/**
 * @author Group-4
 *
 */
public class UserIdAlreadyInUseException extends Exception{
	private int userId;
	
	
	public UserIdAlreadyInUseException(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setProfessorId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String getMessage() {
		return "userId: " + userId + " is already in use.";
	}

}
