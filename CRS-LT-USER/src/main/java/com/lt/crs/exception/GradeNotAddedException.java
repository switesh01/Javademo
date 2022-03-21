package com.lt.crs.exception;

/**
 * Exception to check if student has been alloted grade by professor
 * @author Group-4
 *
 */
public class GradeNotAddedException extends Exception{

	private int studentId;
	 
	/**
	 * Constructor
	 * @param studentId
	 */
	 public GradeNotAddedException(int studentId)
	 {
		 this.studentId=studentId;
	 }
	 
	 /**
	  * Getter function for studentId
	  * @return
	  */
	 public int getStudentId()
	 {
		 return studentId;
	 }
	 
	 
}
