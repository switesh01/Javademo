package com.crs.lt.business;


import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;
import com.crs.lt.bean.Student;
import com.crs.lt.exception.CourseFoundException;
import com.crs.lt.exception.CourseNotDeletedException;
import com.crs.lt.exception.CourseNotFoundException;
import com.crs.lt.exception.ProfessorNotAddedException;
import com.crs.lt.exception.StudentNotFoundForApprovalException;
import com.crs.lt.exception.UserIdAlreadyInUseException;
import com.crs.lt.exception.UserNotFoundException;

/**
 * 
 * @author Group-4
 * 
 */
public interface AdminInterface {
	

	
	public void deleteCourse(String courseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException;
	
	
	public void addCourse(Course course, List<Course> courseList) throws CourseFoundException;
	
	
	public List<Student> viewPendingAdmissions();
	
	
	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException;
	
	
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;	
	
	
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException;
	
	public List<Course> viewCourses(int catalogId);
	
	
	public List<Professor> viewProfessors();
}
