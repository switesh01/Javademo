package com.crs.lt.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Payment;
import com.crs.lt.bean.StudentGrade;
import com.crs.lt.dao.CourseDaoImpl;
import com.crs.lt.dao.CourseDaoInterface;

public class RegistrationCourseOperation implements RegistrationCourseInterface{

	CourseDaoInterface courseDaoInteface = new CourseDaoImpl();
	private final Logger log = Logger.getLogger(RegistrationCourseOperation.class);
	public void registerCourse() {
		// TODO Auto-generated method stub
		
	}

	public void addCourse(Course course) throws SQLException {
		courseDaoInteface.addCourse(course);
		
	}

	public void deleteCourse(String courseCode) throws SQLException {
		courseDaoInteface.deleteCourse(courseCode);
		
	}

	public Course updateCourse(String courseCode, String courseName,
			float courseFee) throws SQLException {
		return courseDaoInteface.updateCourse(courseCode, courseName, courseFee);
		//return Course;
	}

	public List<Course> viewCourse() throws SQLException {
		return courseDaoInteface.viewCourse();
		//return null;
	}

	public List<Course> viewRegisteredCourses(int StudentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<StudentGrade> viewGradeCard(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Payment makePayment(int studentId, String courseCode) {
		// TODO Auto-generated method stub
		return null;
	}



}
