package com.crs.lt.exception;

public class CourseFoundException extends Exception{

	
private String courseCode;
	
	
	public CourseFoundException(String courseCode) {
		this.courseCode = courseCode;
	}
	

	public String getCourseCode() {
		return courseCode;
	}

	
	public String getMessage() {
		return "Course with courseCode: " + courseCode + " already present in catalog.";
	}
}
