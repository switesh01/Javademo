/**
 * 
 */
package com.lt.exception;

/**
 * Exception course is deleted from catalog
 * @author Group-4
 *
 */
public class CourseNotDeletedException extends Exception{
private String courseCode;
	
	public CourseNotDeletedException(String courseCode)
	{	
		this.courseCode = courseCode;
	}

	/**
	 * Getter function for course code
	 * @return
	 */
	public String getCourseCode()
	{
		return courseCode;
	}
	
	/**
	 * Message thrown by exception
	 */
	@Override
	public String getMessage() 
	{
		return "Course with courseCode: " + courseCode + " can not be deleted.";
	}
}
