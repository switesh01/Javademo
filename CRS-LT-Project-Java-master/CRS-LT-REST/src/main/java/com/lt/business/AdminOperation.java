package com.lt.business;

import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.dao.AdminDaoInterface;
import com.lt.dao.AdminDaoOperation;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotDeletedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotAddedException;
import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.exception.UserIdAlreadyInUseException;
import com.lt.exception.UserNotFoundException;

/**
 * 
 * @author JEDI-03
 * Implementations of Admin Operations
 * 
 */
public class AdminOperation implements AdminInterface{

	private static Logger logger = Logger.getLogger(AdminOperation.class);
	private static volatile AdminOperation instance = null;
	
	private AdminOperation()
	{
		
	}
	
	/**
	 * Method to make AdminOperation Singleton
	 */
	public static AdminOperation getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminOperation.class){
				instance = new AdminOperation();
			}
		}
		return instance;
	}
	

	AdminDaoInterface adminDaoOperation =AdminDaoOperation.getInstance();
	
	
	@Override
	public void deleteCourse(String dropCourseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException {
		
		//if(!AdminValidator.isValidDropCourse(dropCourseCode, courseList)) {
			//logger.error("courseCode: " + dropCourseCode + " not present in catalog!");
			//throw new CourseNotFoundException(dropCourseCode);
		//}
		
		try {
			adminDaoOperation.deleteCourse(dropCourseCode);
		}
		catch(CourseNotFoundException | CourseNotDeletedException e) {
			throw e;
		}
		
	}

	
	@Override
	public void addCourse(Course newCourse, List<Course> courseList) throws CourseFoundException {
		
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
	public List<Student> viewPendingAdmissions() {
		return adminDaoOperation.viewPendingAdmissions();
	}
	
	
	@Override
	public void approveStudent(int studentId, List<Student> studentList) throws StudentNotFoundForApprovalException {
		
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
	public void addProfessor(Professor professor) throws ProfessorNotAddedException, UserIdAlreadyInUseException {
		
		try {
			adminDaoOperation.addProfessor(professor);
		}
		catch(ProfessorNotAddedException | UserIdAlreadyInUseException e) {
			throw e;
		}
		
	}

	
	@Override
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException{
		
		try {
			adminDaoOperation.assignCourse(courseCode, professorId);
		}
		catch(CourseNotFoundException | UserNotFoundException e) {
			throw e;
		}
		
	}
	
	
	@Override
	public List<Course> viewCourses(int catalogId) {
		
		return adminDaoOperation.viewCourses(catalogId);
		
	}
	
	
	@Override
	public List<Professor> viewProfessors() {
		
		return adminDaoOperation.viewProfessors();
		
	}
}
