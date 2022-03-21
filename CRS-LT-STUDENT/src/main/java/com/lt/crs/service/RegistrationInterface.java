package com.lt.crs.service;

import java.sql.SQLException;
import java.util.List;

import com.lt.crs.exception.CourseLimitExceedException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.SeatNotAvailableException;
import com.lt.crs.model.Course;
import com.lt.crs.model.RegisteredCourse;
import com.lt.crs.model.StudentGrade;

/**
 * 
 * @author Group-4
 */
public interface RegistrationInterface {

	public boolean addCourse(RegisteredCourse registeredCourse) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException;

	public boolean dropCourse(int studentId) throws CourseNotFoundException;

//	public List<Course> viewCourses(int studentId) throws SQLException;
//
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException;
//	
	public List<StudentGrade> viewGradeCard(int studentId) throws SQLException;
//	
//	public double calculateFee(int studentId) throws SQLException;
//
//	public boolean getRegistrationStatus(int studentId);
//	
//	public void setRegistrationStatus(int studentId) throws SQLException;
	
}

































/*
public interface RegistrationInterface {
	
	
	public boolean addCourse(String courseCode, int studentId, List<Course> courseList) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException, SQLException ;
	
	
	public boolean dropCourse(String courseCode, int studentId, List<Course> registeredCourseList) throws CourseNotFoundException, SQLException;
	
	
	public List<Course> viewCourses(int studentId) throws SQLException;
	
	
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException;
	
	
	public List<StudentGrade> viewGradeCard(int studentId) throws SQLException;
	
	public double calculateFee(int studentId) throws SQLException;

	public boolean getRegistrationStatus(int studentId) throws SQLException;
	
	public void setRegistrationStatus(int studentId) throws SQLException;
	
}
*/