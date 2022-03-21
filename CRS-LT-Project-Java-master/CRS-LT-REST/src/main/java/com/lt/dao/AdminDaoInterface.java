/**
 * 
 */
package com.crs.lt.dao;

import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;
import com.crs.lt.bean.Student;
import com.crs.lt.bean.User;
import com.crs.lt.exception.CourseFoundException;
import com.crs.lt.exception.CourseNotDeletedException;
import com.crs.lt.exception.CourseNotFoundException;
import com.crs.lt.exception.ProfessorNotAddedException;
import com.crs.lt.exception.StudentNotFoundForApprovalException;
import com.crs.lt.exception.UserIdAlreadyInUseException;
import com.crs.lt.exception.UserNotAddedException;
import com.crs.lt.exception.UserNotFoundException;


/**
 * @author Group-4
 *
 */
public interface AdminDaoInterface {
	
	
	public void deleteCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException;

	
	public void addCourse(Course course) throws CourseFoundException;
	
	public List<Student> viewPendingAdmissions();
	
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException;
	
	
	
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException;
	
	
	public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException;
	
	
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException;
	
	
	public List<Course> viewCourses(int catalogId);
	
	
	public List<Professor> viewProfessors();
}
