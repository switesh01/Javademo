package com.lt.business;

import com.lt.bean.Course;
import com.lt.bean.EnrolledStudent;
import com.lt.exception.GradeNotAddedException;

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
	
	
	public List<Course> getCourses(int userId) throws Exception;
	
	public String getProfessorById(String profId) throws SQLException;
}
