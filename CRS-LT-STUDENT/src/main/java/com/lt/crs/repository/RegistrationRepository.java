/**
 * 
 */
package com.lt.crs.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.model.Course;
import com.lt.crs.model.RegisteredCourse;
import com.lt.crs.model.StudentGrade;

/**
 * @author Group-4
 * Interface for Registration DAO Operation
 *
 */
@Repository
public interface RegistrationRepository extends JpaRepository<RegisteredCourse, Integer> {
	
	/**
	 * Method to add course in database
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is added successfully
	 * @throws SQLException 
	 */
//	public boolean addCourse(String courseCode, int studentId) throws SQLException;
	
	/**
	 * Drop Course selected by student
	 * @param courseCode
	 * @param studentId
	 * @return boolean indicating if the course is dropped successfully
	 * @throws CourseNotFoundException 
	 * @throws SQLException 
	 */
//	public boolean dropCourse(String courseCode, int studentId) throws SQLException;
	/**
	 * Method to get the list of courses available from course catalog 
	 * @param studentId
	 * @return list of Courses
	 * @throws SQLException 
	 */
	@Query(value = "select * from course where course_code not in  (select course_code  from registered_course where student_id = :studentId) and seats > 0",
			nativeQuery = true)
	public List<Course> viewCourses(@Param("studentId") int studentId);
	
	/**
	 * Method to View list of Registered Courses
	 * @param studentId
	 * @return list of Registered Courses
	 * @throws SQLException 
	 */
	@Query(value = "select * from course where course_code not in  (select course_code  from registered_course where student_id = :studentId) and seats > 0",
			nativeQuery = true)
	public List<Course> viewRegisteredCourses(@Param("studentId") int studentId);
	
	/**
	 * Method to view grade card of the student
	 * @param studentId
	 * @return Grade Card
	 * @throws SQLException 
	 */
//	public List<StudentGrade> viewGradeCard(int studentId);
	
	/**
	 * Method to retrieve fee for the selected courses from the database and calculate total fee
	 * @param studentId
	 * @return Fee Student has to pay
	 * @throws SQLException 
	 */
//	public double calculateFee(int studentId);
	
	/**
	 * Check if seat is available for that particular course
	 * @param courseCode
	 * @return seat availability status
	 * @throws SQLException 
	 */
//	public boolean seatAvailable(String courseCode);
	
	/**
	 * Method to get the list of courses registered by the student
	 * Number of registered courses for a student
	 * @param studentId
	 * @return Number of registered Courses
	 * @throws SQLException 
	 */
//	public int numOfRegisteredCourses(int studentId);
	
	/**
	 * Method checks if the student is registered for that course
	 * @param courseCode
	 * @param studentId
	 * @return Students registration status
	 * @throws SQLException 
	 */
//	public boolean isRegistered(String courseCode, int studentId);
	
	/**
	 *  Method to get student registration status
	 * @param studentId
	 * @return Student's registration status
	 * @throws SQLException
	 */
//	public boolean getRegistrationStatus(int studentId);
	
	/**
	 *  Method to set student registration status
	 * @param studentId
	 * @throws SQLException
	 */
//	public void setRegistrationStatus(int studentId) throws SQLException;
	
	
}