package com.crs.lt.bean;

import java.util.List;

public class GradeCard {
private int studentId;
private int semester;
private float cgpa;
private List<RegisteredCourse> registeredCourse;
public int getStudentId() {
	return studentId;
}
public void setStudentId(int studentId) {
	this.studentId = studentId;
}
public int getSemester() {
	return semester;
}
public void setSemester(int semester) {
	this.semester = semester;
}
public float getCgpa() {
	return cgpa;
}
public void setCgpa(float cgpa) {
	this.cgpa = cgpa;
}
public List<RegisteredCourse> getRegisteredCourse() {
	return registeredCourse;
}
public void setRegisteredCourse(List<RegisteredCourse> registeredCourse) {
	this.registeredCourse = registeredCourse;
}

 
}
