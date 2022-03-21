package com.crs.lt.business;

import java.sql.SQLException;
import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Payment;
import com.crs.lt.bean.StudentGrade;

public interface RegistrationCourseInterface {
	public void registerCourse();

	public void addCourse(Course course) throws SQLException ;

	public void deleteCourse(String courseCode) throws SQLException ;
	
	public Course updateCourse(String courseCode, String courseName, float courseFee) throws SQLException;
	
	public List<Course> viewCourse()throws SQLException ;
	
	public List<Course> viewRegisteredCourses(int StudentId);
	
	public List<StudentGrade> viewGradeCard(int studentId);
	
	public Payment makePayment(int studentId, String courseCode);
}
