package com.crs.lt.business;

import java.sql.SQLException;
import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Notification;
import com.crs.lt.bean.StudentGrade;
import com.crs.lt.constant.ModeOfPayment;
import com.crs.lt.dao.RegistrationDaoInterface;
import com.crs.lt.dao.RegistrationDaoOperation;
import com.crs.lt.exception.CourseLimitExceedException;
import com.crs.lt.exception.CourseNotFoundException;
import com.crs.lt.exception.SeatNotAvailableException;

/**
 * @author Group-4
 * 
 */
public class RegistrationOperation implements RegistrationInterface {

	private static volatile RegistrationOperation instance = null;

	private RegistrationOperation() {
	}

	
	public static RegistrationOperation getInstance() {
		if (instance == null) {
			synchronized (RegistrationOperation.class) {
				instance = new RegistrationOperation();
			}
		}
		return instance;
	}

	RegistrationDaoInterface registrationDaoInterface = RegistrationDaoOperation.getInstance();

	
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
