package com.lt.crs.service;

import java.util.List;

import com.lt.crs.exception.GradeNotAddedException;
import com.lt.crs.model.Course;
import com.lt.crs.model.EnrolledStudent;

/**
 * 
 * @author Group-4
 * 
 */
public interface ProfessorInterface {
	
	public boolean addGrade(int studentId,String courseCode,String grade) throws GradeNotAddedException;
	
	
	public List<EnrolledStudent> viewEnrolledStudents(int profId);
	
	
	public List<Course> getCourses(int userId) throws Exception;
	
	public String getProfessorById(int profId);
}
