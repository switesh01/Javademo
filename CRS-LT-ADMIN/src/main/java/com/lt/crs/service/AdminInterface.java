package com.lt.crs.service;


import java.sql.SQLException;
import java.util.List;

import com.lt.crs.model.Course;
import com.lt.crs.model.Professor;
import com.lt.crs.model.Student;
import com.lt.crs.dto.ProfessorDto;
import com.lt.crs.dto.StudentDto;
import com.lt.crs.exception.CourseFoundException;
import com.lt.crs.exception.CourseNotDeletedException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.ProfessorNotAddedException;
import com.lt.crs.exception.StudentNotFoundForApprovalException;
import com.lt.crs.exception.UserIdAlreadyInUseException;
import com.lt.crs.exception.UserNotAddedException;
import com.lt.crs.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 * 
 */
public interface AdminInterface {
	

	
	public void deleteCourse(String courseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException, SQLException;
	
	
	public void addCourse(Course course) throws CourseFoundException, SQLException;
	
	
	public List<StudentDto> viewPendingAdmissions() throws SQLException;
	
	
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException, SQLException;
	
	
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException, SQLException, UserNotAddedException;	
	
	
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException, SQLException;
	
	public List<Course> viewCourses(int catalogId) throws SQLException;
	
	
	public List<String> viewProfessors() throws SQLException;
}




























































/*
public interface AdminInterface {
	

	
	public void deleteCourse(String courseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException, SQLException;
	
	
	public void addCourse(Course course, List<Course> courseList) throws CourseFoundException, SQLException;
	
	
	public List<Student> viewPendingAdmissions() throws SQLException;
	
	
	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException, SQLException;
	
	
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException, SQLException, UserNotAddedException;	
	
	
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException, SQLException;
	
	public List<Course> viewCourses(int catalogId) throws SQLException;
	
	
	public List<Professor> viewProfessors() throws SQLException;
}
*/