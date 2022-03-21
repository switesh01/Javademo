package com.crs.lt.exception;

public class GradeNotAddedException extends Exception{

	
	private int studentId;
	 
	
	 public GradeNotAddedException(int studentId)
	 {
		 this.studentId=studentId;
	 }
	 
	
	 public int getStudentId()
	 {
		 return studentId;
	 }
	 
}
