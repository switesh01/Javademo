package com.lt.crs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registered_course")
public class RegisteredCourse {

	@Id
	@Column(name = "student_id")
	public int studentId;

	@Column(name = "course_code")
	public String courseCode;

	public String grade;

	public RegisteredCourse(int studentId, String courseCode, String grade) {
		super();
		this.studentId = studentId;
		this.courseCode = courseCode;
		this.grade = grade;
	}

	public RegisteredCourse() {
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
}
