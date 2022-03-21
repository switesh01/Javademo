package com.lt.crs.exception;

/**
 * Exception to check if the professor is not added successfully by admin
 * @author Group-4
 *
 */
public class ProfessorNotAddedException extends Exception{
	private int professorId;
	
	public ProfessorNotAddedException(int professorId) {
		this.professorId = professorId;
	}
	
	/**
	 * Getter function for professorId
	 * @return
	 */
	public int getUserId() {
		return this.professorId;
	}
	

	/**
	 * Message returned when exception is thrown
	 */
	@Override
	public String getMessage() {
		return "professorId: " + professorId + " not added!";
	}
}
