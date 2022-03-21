package com.lt.business;


import java.sql.SQLException;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotDeletedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotAddedException;
import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.exception.UserIdAlreadyInUseException;
import com.lt.exception.UserNotAddedException;
import com.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 * 
 */
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
