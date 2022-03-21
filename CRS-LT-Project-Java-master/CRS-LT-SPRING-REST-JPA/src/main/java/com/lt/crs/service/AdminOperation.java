package com.lt.crs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.crs.model.Course;
import com.lt.crs.model.EnrolledStudent;
import com.lt.crs.model.Professor;
import com.lt.crs.model.Student;
import com.lt.crs.repository.AdminRepository;
import com.lt.crs.repository.CourseRepository;
import com.lt.crs.repository.ProfessorRepository;
import com.lt.crs.constant.Role;
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
 * Implementations of Professor Operations
 * 
 */
@Service
@Transactional
public class AdminOperation implements AdminInterface{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public void deleteCourse(String dropCourseCode, List<Course> courseList) throws CourseNotFoundException, CourseNotDeletedException, SQLException {
		courseRepository.deleteById(dropCourseCode);
	}

	@Override
	public void addCourse(Course newCourse) throws CourseFoundException, SQLException {
		Course course=new Course();
		course.setCourseCode(newCourse.getCourseCode());
		course.setCourseName(newCourse.getCourseName());
		course.setCatalogId(newCourse.getCatalogId());
		course.setSeats(10);
		course.setProfessorId(503);
		courseRepository.save(course);
	}

	@Override
	public List<StudentDto> viewPendingAdmissions() throws SQLException {
		System.out.println("service: "+adminRepository.viewPendingAdmissions());
		List<StudentDto> pendingAdmissionsList=new ArrayList<StudentDto>();
		for(Object[] obj: adminRepository.viewPendingAdmissions()) {
			StudentDto es=new StudentDto();
			es.setId((int)obj[0]);
			es.setName((String)obj[1]);
			es.setRole(Role.STUDENT);
			es.setPassword((String)obj[3]);
			es.setBranchName((String)obj[5]);
			es.setBatch((int)obj[6]);
			pendingAdmissionsList.add(es);
		}
		System.out.println("service: "+pendingAdmissionsList);
		return pendingAdmissionsList;
	
	}
	
	@Override
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException, SQLException {
		try {
			adminRepository.approveStudent(studentId);
		}
		catch(StudentNotFoundForApprovalException e) {
			throw e;
		}
		
	}

	@Override
	public void addProfessor(Professor professor) {
		professorRepository.save(professor);
	}

	@Override
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException, SQLException{
		try {
			adminRepository.assignCourse(courseCode, professorId);
		}
		catch(CourseNotFoundException | UserNotFoundException e) {
			throw e;
		}
	}
	
	@Override
	public List<Course> viewCourses(int catalogId) throws SQLException {
		List<Course> courseList=new ArrayList<Course>();
		for(Object[] obj: adminRepository.viewCourses(catalogId)) {
			Course course=new Course((String)obj[0], (String)obj[1], (int)obj[4]);
			course.setCatalogId((int)obj[2]);
			course.setSeats((int)obj[3]);
			courseList.add(course);
		}
		return courseList;
		
	}
//	
//	@Override
//	public List<Professor> viewProfessors() throws SQLException {
//		
//		return adminRepository.viewProfessors();
//		
//	}


	
}



















































/*
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
*/