package com.crs.lt.business;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.EnrolledStudent;
import com.crs.lt.exception.GradeNotAddedException;

import java.sql.SQLException;
import java.util.List;

/**
 * 
 * @author Group-4
 * 
 */
public interface ProfessorInterface {
	
	
	public boolean addGrade(int studentId,String courseCode,String grade) throws GradeNotAddedException;
	
	
	public List<EnrolledStudent> viewEnrolledStudents(int profId) throws SQLException;
	
	
	public List<Course> getCourses(int userId);
	
	public String getProfessorById(String profId);
}
