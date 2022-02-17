package com.crs.lt.bean;

public class RegisteredCourse {
private Course courseCode;
private SemesterRegistration semester;
private Student studentId;
private Grade grade;
public Course getCourseCode() {
	return courseCode;
}
public void setCourseCode(Course courseCode) {
	this.courseCode = courseCode;
}

public SemesterRegistration getSemester() {
	return semester;
}
public void setSemester(SemesterRegistration semester) {
	this.semester = semester;
}
public Student getStudentId() {
	return studentId;
}
public void setStudentId(Student studentId) {
	this.studentId = studentId;
}
public Grade getGrade() {
	return grade;
}
public void setGrade(Grade grade) {
	this.grade = grade;
}
}
