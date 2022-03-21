package com.lt.business;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.dao.AdminDaoInterface;
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
 * Implementations of Professor Operations
 * 
 */
@Service
public class AdminOperation implements AdminInterface{

	@Autowired
	AdminDaoInterface adminDaoOperation;
	
	@Override
	public void deleteCourse(String dropCourseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException, SQLException {
		try {
			adminDaoOperation.deleteCourse(dropCourseCode);
		}
		catch(CourseNotFoundException | CourseNotDeletedException e) {
			throw e;
		}
	}

	
	@Override
	public void addCourse(Course newCourse, List<Course> courseList) throws CourseFoundException, SQLException {
		
		//if(!AdminValidator.isValidNewCourse(newCourse, courseList)) {
			//logger.error("courseCode: " + newCourse.getCourseCode() + " already present in catalog!");
			//throw new CourseFoundException(newCourse.getCourseCode());
		//}
		
		try {
			adminDaoOperation.addCourse(newCourse);
		}
		catch(CourseFoundException e) {
			throw e;
		}
		
	}


	@Override
	public List<Student> viewPendingAdmissions() throws SQLException {
		System.out.println("service: "+adminDaoOperation.viewPendingAdmissions());
		return adminDaoOperation.viewPendingAdmissions();
	}
	
	
	@Override
	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException, SQLException {
		
		//if(!AdminValidator.isValidUnapprovedStudent(studentId, studentList)) {
			//logger.error("studentId: " + studentId + " is already approvet/not-present!");
			//throw new StudentNotFoundForApprovalException(studentId);
		//}
		
		try {
			adminDaoOperation.approveStudent(studentId);
		}
		catch(StudentNotFoundForApprovalException e) {
			throw e;
		}
		
	}

	
	@Override
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException, SQLException, UserNotAddedException {
		
		try {
			adminDaoOperation.addProfessor(professor);
		}
		catch(ProfessorNotAddedException | UserIdAlreadyInUseException e) {
			throw e;
		}
		
	}

	
	@Override
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException, SQLException{
		
		try {
			adminDaoOperation.assignCourse(courseCode, professorId);
		}
		catch(CourseNotFoundException | UserNotFoundException e) {
			throw e;
		}
		
	}
	
	
	@Override
	public List<Course> viewCourses(int catalogId) throws SQLException {
		
		return adminDaoOperation.viewCourses(catalogId);
		
	}
	
	
	@Override
	public List<Professor> viewProfessors() throws SQLException {
		
		return adminDaoOperation.viewProfessors();
		
	}
}
