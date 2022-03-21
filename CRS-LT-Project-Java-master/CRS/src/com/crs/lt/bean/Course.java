/**
 * 
 */
package com.crs.lt.bean;

/**
 * @author user218
 *
 */
public class Course {
	private String courseCode;
	private String courseName;
	private int catalogId;	
	private int seats;
	private float courseFee;
	private int professorId;

	public Course() {
		 courseCode = null;
		 courseName = null;
		 catalogId = 0;	
		 seats = 0;
		 courseFee = 0.0f;
		 professorId = 0;
	}

	public Course(String courseCode, String courseName, int catalogId,
			int seats, float courseFee, int professorId ) {
		super();
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.catalogId = catalogId;		
		this.seats = seats;
		this.courseFee = courseFee;
		this.professorId = professorId;
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

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public float getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(float courseFee) {
		this.courseFee = courseFee;
	}

}
