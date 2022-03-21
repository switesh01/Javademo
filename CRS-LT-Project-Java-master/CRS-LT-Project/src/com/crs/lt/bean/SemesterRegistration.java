package com.crs.lt.bean;

import java.util.Date;

public class SemesterRegistration {
private Student studentId;
private int semester;
private Date dateOfRegistration;
public Student getStudentId() {
	return studentId;
}
public void setStudentId(Student studentId) {
	this.studentId = studentId;
}
public int getSemester() {
	return semester;
}
public void setSemester(int semester) {
	this.semester = semester;
}
public Date getDateOfRegistration() {
	return dateOfRegistration;
}
public void setDateOfRegistration(Date dateOfRegistration) {
	this.dateOfRegistration = dateOfRegistration;
}
}
