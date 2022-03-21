package com.lt.crs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.crs.exception.CourseLimitExceedException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.SeatNotAvailableException;
import com.lt.crs.model.Course;
import com.lt.crs.model.RegisteredCourse;
import com.lt.crs.model.StudentGrade;
import com.lt.crs.repository.CourseRepository;
import com.lt.crs.repository.RegisteredCourseRepository;
import com.lt.crs.repository.RegistrationRepository;

/**
 * @author Group-4
 * 
 */
@Service
@Transactional
public class RegistrationOperation implements RegistrationInterface {

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public boolean addCourse(RegisteredCourse registeredCourse) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException 
	{
		return registrationRepository.save(registeredCourse).getStudentId() > 0 ? true : false;
		
//		if (registrationRepository.isRegistered(courseCode, studentId)) 
//		{
//			return false;
//		} 
//		else if(!registrationRepository.seatAvailable(courseCode)) 
//		{
//			throw new SeatNotAvailableException(courseCode);
//		} 
//		else if(!StudentValidator.isValidCourseCode(courseCode, availableCourseList))
//		{
//			throw new CourseNotFoundException(courseCode);
//		}
		
//		return registrationRepository.addCourse(courseCode, studentId);

	}

	@Override
	public boolean dropCourse(int studentId) throws CourseNotFoundException {
		int before=registrationRepository.findAll().size();
		registrationRepository.deleteById(studentId);
		int after=registrationRepository.findAll().size();
		
		if((before - after) == 1)
			return true;
		return false;
		
//		  if(!StudentValidator.isRegistered(courseCode, studentId, registeredCourseList))
//	        {
//	        	throw new CourseNotFoundException(courseCode);
//	        }

	}

//	@Override
//	public double calculateFee(int studentId) throws SQLException {
//		return registrationRepository.calculateFee(studentId);
//	}

	@Override
	public List<StudentGrade> viewGradeCard(int studentId) throws SQLException {
		List<StudentGrade> studentGradeCardList=new ArrayList<StudentGrade>();
		for(Object[] obj: courseRepository.viewGradeCard(studentId)) {
			StudentGrade studentGrade=new StudentGrade((String)obj[0], (String)obj[1], (String)obj[2]);
			studentGradeCardList.add(studentGrade);
		}
		return studentGradeCardList;
	}

	
//	public List<Course> viewCourses(int studentId) throws SQLException {
//		return registrationRepository.viewCourses(studentId);
//	}
//
//	
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException {
		return registrationRepository.viewRegisteredCourses(studentId);
	}
//    
//	
//	
//	public boolean getRegistrationStatus(int studentId) {
//		return registrationRepository.getRegistrationStatus(studentId);
//	}
//	
//
//	
//	public void setRegistrationStatus(int studentId) throws SQLException {
//		registrationRepository.setRegistrationStatus(studentId);
//
//	}

}



































































/*
@Service
public class RegistrationOperation implements RegistrationInterface {

	@Autowired
	RegistrationDaoInterface registrationDaoInterface;
	
	@Override
	public boolean addCourse(String courseCode, int studentId,List<Course> availableCourseList) throws CourseNotFoundException, CourseLimitExceedException, SeatNotAvailableException, SQLException 
	{
       
		

		
		if (registrationDaoInterface.isRegistered(courseCode, studentId)) 
		{
			return false;
		} 
		else if(!registrationDaoInterface.seatAvailable(courseCode)) 
		{
			throw new SeatNotAvailableException(courseCode);
		} 
//		else if(!StudentValidator.isValidCourseCode(courseCode, availableCourseList))
//		{
//			throw new CourseNotFoundException(courseCode);
//		}
		
		  

		return registrationDaoInterface.addCourse(courseCode, studentId);

	}

	
	@Override
	public boolean dropCourse(String courseCode, int studentId,List<Course> registeredCourseList) throws CourseNotFoundException, SQLException {
//		  if(!StudentValidator.isRegistered(courseCode, studentId, registeredCourseList))
//	        {
//	        	throw new CourseNotFoundException(courseCode);
//	        }
		
		return registrationDaoInterface.dropCourse(courseCode, studentId);

	}

	
	@Override
	public double calculateFee(int studentId) throws SQLException {
		return registrationDaoInterface.calculateFee(studentId);
	}


	
	@Override
	public List<StudentGrade> viewGradeCard(int studentId) throws SQLException {
		return registrationDaoInterface.viewGradeCard(studentId);
	}

	
	@Override
	public List<Course> viewCourses(int studentId) throws SQLException {
		return registrationDaoInterface.viewCourses(studentId);
	}

	
	@Override
	public List<Course> viewRegisteredCourses(int studentId) throws SQLException {
		return registrationDaoInterface.viewRegisteredCourses(studentId);
	}
    
	
	@Override
	public boolean getRegistrationStatus(int studentId) throws SQLException {
		return registrationDaoInterface.getRegistrationStatus(studentId);
	}
	

	@Override
	public void setRegistrationStatus(int studentId) throws SQLException {
		registrationDaoInterface.setRegistrationStatus(studentId);

	}

}
*/