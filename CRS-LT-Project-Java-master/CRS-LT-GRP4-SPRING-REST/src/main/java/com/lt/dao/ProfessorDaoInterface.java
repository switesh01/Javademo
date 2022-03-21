package com.lt.dao;

import java.sql.SQLException;
import java.util.*;

import com.lt.bean.Course;
import com.lt.bean.EnrolledStudent;
import com.lt.bean.Student;

/**
 * 
 * @author Group-4
 * Interface for Admin Dao Operations
 * 
 */
public interface ProfessorDaoInterface {
	
	/**
	 * Method to get Courses by Professor Id using SQL Commands
	 * @param userId, prof id of the professor
	 * @return get the courses offered by the professor.
	 */
	public List<Course> getCoursesByProfessor(int profId) throws SQLException;
	
	
	/**
	 * Method to view list of enrolled Students using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	public List<EnrolledStudent> getEnrolledStudents(int profId) throws SQLException;
	
	/**
	 * Method to Grade a student using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code for the corresponding 
	 * @return: returns the status after adding the grade
	 */
	public Boolean addGrade(int studentId,String courseCode,String grade) throws SQLException;


	/**
	 * Method to Get professor name by id
	 * @param profId
	 * @return Professor Id in string
	 * @throws SQLException 
	 */
	public String getProfessorById(String profId) throws SQLException;
}
