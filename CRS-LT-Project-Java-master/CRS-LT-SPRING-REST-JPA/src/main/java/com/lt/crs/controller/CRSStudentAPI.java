package com.lt.crs.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constant.ModeOfPayment;
import com.lt.crs.exception.CourseAlreadyRegisteredException;
import com.lt.crs.exception.CourseLimitExceedException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.SeatNotAvailableException;
import com.lt.crs.model.Course;
import com.lt.crs.model.RegisteredCourse;
import com.lt.crs.model.StudentGrade;
import com.lt.crs.service.ProfessorInterface;
import com.lt.crs.service.RegistrationInterface;

/**
 * @author user218
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class CRSStudentAPI {

	@Autowired
	RegistrationInterface registrationInterface;
	
	@Autowired
	ProfessorInterface professorInterface;

	private static Logger logger = Logger.getLogger(CRSStudentAPI.class);

	/**
	 * Method to handle API request for course registration
	 * 
	 * @param courseList
	 * @param studentId
	 * @return
	 * @throws SQLException
	 */
	@PostMapping(path = "/registerCourseToStudent")
	public ResponseEntity<String> registerCourseToStudent(@RequestBody RegisteredCourse registeredCourse)
			throws CourseAlreadyRegisteredException, SQLException {
		try {
			registrationInterface.addCourse(registeredCourse);
		} catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Courses registered to student "+registeredCourse.getStudentId(), HttpStatus.OK);
	}

	/**
	 * Handles api request to add a course
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	@PostMapping(path = "/addCourseToStudent")
	public ResponseEntity<String> addCourseToStudent(@RequestBody RegisteredCourse registeredCourse)
			throws CourseAlreadyRegisteredException, SQLException {
		try {
			registrationInterface.addCourse(registeredCourse);
		} catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Courses registered to student "+registeredCourse.getStudentId(), HttpStatus.OK);
	}
	
	/*
	@PostMapping(value = "/addCourse")
	public ResponseEntity<String> addCourse(@RequestParam("courseCode") String courseCode,
			@RequestParam("studentId") int studentId) throws CourseLimitExceedException, SeatNotAvailableException,
			CourseNotFoundException, CourseAlreadyRegisteredException, SQLException {
		if (registrationInterface.getRegistrationStatus(studentId) == false)
			return new ResponseEntity<String>("Student course registration is pending", HttpStatus.NOT_FOUND);
		try {
			List<Course> availCourseList = registrationInterface.viewCourses(studentId);
			registrationInterface.addCourse(courseCode, studentId, availCourseList);
			return new ResponseEntity<String>("You have successfully added Course: " + courseCode, HttpStatus.OK);
		} catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException e) {
			logger.info(e.getMessage());
			return new ResponseEntity<String>("Course not added: " + courseCode, HttpStatus.BAD_REQUEST);
		}
	}
	*/

	/**
	 * Handles API request to drop a course
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
//	@DeleteMapping(value = "/dropCourseByStudent")
//	public ResponseEntity<String> dropCourseByStudent(@RequestParam("studentId") int studentId) throws CourseNotFoundException {
//
//		if (registrationInterface.getRegistrationStatus(studentId) == false)
//			return new ResponseEntity<String>("course not found", HttpStatus.NOT_FOUND);
//		try {
////			List<Course> registeredCourseList = registrationInterface.viewRegisteredCourses(studentId);
//			registrationInterface.dropCourse(studentId);
//			return new ResponseEntity<String>("Course dropped", HttpStatus.OK);
//		} catch (CourseNotFoundException e) {
//			logger.info(e.getMessage());
//			return new ResponseEntity<String>("Course dropped", HttpStatus.BAD_REQUEST);
//		}
//
//	}

	/**
	 * Method handles API request to view the list of available courses for a
	 * student
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
//	@GetMapping(value = "/viewAvailableCourses")
//	public List<Course> viewCourse(@RequestParam("studentId") int studentId) throws SQLException {
//
//		return registrationInterface.viewCourses(studentId);
//
//	}

	/**
	 * Method handles API request to view the list of registered courses for student
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */

	@GetMapping(value = "/viewRegisteredCourses")
	public List<Course> viewRegisteredCourse(@RequestParam("studentId") int studentId) throws SQLException {

		return registrationInterface.viewRegisteredCourses(studentId);
	}

//	@PostMapping(value = "/makePayment")
//	public ResponseEntity<String> makePayment(@RequestParam("studentId") int studentId,
//			@RequestParam("paymentMode") int paymentMode) throws SQLException {
//		double fee = registrationInterface.calculateFee(studentId);
//
//		fee = registrationInterface.calculateFee(studentId);
//		logger.info("Your total fee  = " + fee);
//		ModeOfPayment mode = ModeOfPayment.getModeofPayment(paymentMode);
//
//		logger.info("Your Payment is successful");
//		// logger.info("Your transaction id : " + notify.getReferenceId());
//
//		return new ResponseEntity<String>("Your total fee  = " + fee + "\n" + "Your Payment is successful\n",
//				HttpStatus.OK);
//	}

	/**
	 * Method handles request to display the total fees for student
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */

//	@GetMapping(value = "/calculateFees")
//	public ResponseEntity<String> calculateFee(@RequestParam("studentId") int studentId) throws SQLException {
//
//		double fee = registrationInterface.calculateFee(studentId);
//		return new ResponseEntity<String>("Your total fee  = " + fee + "\n", HttpStatus.OK);
//	}

	/**
	 * Method handles request to display the grade card for student
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	@GetMapping(value = "/viewGradeCard")
	public List<StudentGrade> viewGradeCard(@RequestParam("studentId") Integer studentId) throws SQLException {
		List<StudentGrade> gradeCard = registrationInterface.viewGradeCard(studentId);
		return gradeCard;
	}

}
