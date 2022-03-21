package com.lt.business;

import java.sql.SQLException;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Notification;
import com.lt.bean.StudentGrade;
import com.lt.constant.ModeOfPayment;
import com.lt.exception.CourseLimitExceedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.SeatNotAvailableException;

/**
 * 
 * @author Group-4
 */
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
