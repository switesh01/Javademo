package com.lt.bean;

/**
 * 
 * @author Group-4
 * 
 */
public class Course {

	private String courseCode;
	private String courseName;
	private int professorId;
	private static int seats = 10;
	private int catalogId;
	
	public Course() {
		
	}
	
	public Course(String courseCode, String courseName, int professorId) 
	{
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.setProfessorId(professorId);
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	
	public String getCourseName() {
		return courseName;
	}
	
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getSeats() {
		return seats;
	}
	
	
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	
	public int getProfessorId() {
		return professorId;
	}
	
	
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	@Override
	public String toString() {
		return "Course [courseCode=" + courseCode + ", courseName=" + courseName + ", professorId=" + professorId
				+ ", catalogId=" + catalogId + ", seats=" + seats + "]";
	}
	
}
