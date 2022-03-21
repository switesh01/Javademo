package com.lt.crs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Group-4
 * 
 */

@Entity
@Table(name="course")
public class Course {

	@Id
	@Column(name="course_code")
	private String courseCode;
	

	@Column(name="course_name")
	private String courseName;
	
	
	@Column(name="professor_id")
	private int professorId;
	

	@Column(name="seats")
	private int seats;
	
	
	@Column(name="catalog_id")
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
