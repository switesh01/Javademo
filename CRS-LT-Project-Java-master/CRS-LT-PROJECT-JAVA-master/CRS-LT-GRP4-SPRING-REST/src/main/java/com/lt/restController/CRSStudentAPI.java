/**
 * 
 */
package com.lt.restController;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lt.business.NotificationInterface;
import com.lt.business.NotificationOperation;
import com.lt.business.ProfessorOperation;
import com.lt.business.RegistrationOperation;
import com.lt.bean.Course;
import com.lt.bean.Notification;
import com.lt.bean.StudentGrade;
import com.lt.business.ProfessorInterface;
import com.lt.business.RegistrationInterface;
import com.lt.constant.ModeOfPayment;
import com.lt.exception.CourseAlreadyRegisteredException;
import com.lt.exception.CourseLimitExceedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.SeatNotAvailableException;

import org.apache.log4j.Logger;


/**
 * @author user218
 *
 */
@RestController
@RequestMapping("/student")
public class CRSStudentAPI {


	
	RegistrationInterface registrationInterface = RegistrationOperation.getInstance();
	ProfessorInterface professorInterface = ProfessorOperation.getInstance();
	

	private static Logger logger = Logger.getLogger(CRSStudentAPI.class);

	/**
	 * Method to handle API request for course registration
	 * 
	 * @param courseList
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 */
	@PostMapping(path = "/registerCourses", produces = MediaType.APPLICATION_JSON, consumes = "application/json")
	public Response registerCourses(List<String> courseList, @QueryParam("studentId") int studentId)
			throws  CourseLimitExceedException, SeatNotAvailableException, CourseNotFoundException, CourseAlreadyRegisteredException, SQLException {

		try {
			List<Course> availableCourseList = registrationInterface.viewCourses(studentId);
			Set<String> hash_set = new HashSet<String>();
			for (String courseCode : courseList)
				registrationInterface.addCourse(courseCode, studentId, availableCourseList);
			registrationInterface.setRegistrationStatus(studentId);
		} catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException e) {
			logger.info(e.getMessage());
			return Response.status(500).entity(e.getMessage()).build();
		}

		return Response.status(201).entity("Registration Successful").build();

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
	@PutMapping(value = "/addCourse", produces = MediaType.APPLICATION_JSON)
	public Response addCourse(@QueryParam("courseCode") String courseCode, @QueryParam("studentId") int studentId)
			throws  CourseLimitExceedException, SeatNotAvailableException, CourseNotFoundException, CourseAlreadyRegisteredException, SQLException {

		if (registrationInterface.getRegistrationStatus(studentId) == false)
			return Response.status(200).entity("Student course registration is pending").build();

		try {

			List<Course> availCourseList = registrationInterface.viewCourses(studentId);
			registrationInterface.addCourse(courseCode, studentId, availCourseList);

			return Response.status(201).entity("You have successfully added Course : " + courseCode).build();

		} catch (CourseLimitExceedException | SeatNotAvailableException | CourseNotFoundException e) {
			logger.info(e.getMessage());

			return Response.status(500).entity(e.getMessage()).build();
		}

	}

	/**
	 * Handles API request to drop a course
	 * 
	 * @param courseCode
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	@DeleteMapping(value = "/dropCourse", produces = MediaType.APPLICATION_JSON)
	public Response dropCourse(@QueryParam("courseCode") String courseCode, @QueryParam("studentId") int studentId)
			throws CourseNotFoundException, SQLException {

		if (registrationInterface.getRegistrationStatus(studentId) == false)
			return Response.status(200).entity("Student course registration is pending").build();

		try {

			List<Course> registeredCourseList = registrationInterface.viewRegisteredCourses(studentId);
			registrationInterface.dropCourse(courseCode, studentId, registeredCourseList);
			return Response.status(201).entity("You have successfully dropped Course : " + courseCode).build();
		} catch (CourseNotFoundException e) {
			logger.info(e.getMessage());
			return Response.status(501).entity("You have not registered for course : " + e.getCourseCode()).build();
		}

	}

	/**
	 * Method handles API request to view the list of available courses for a
	 * student
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	@GetMapping(value = "/viewAvailableCourses", produces = MediaType.APPLICATION_JSON)
	public List<Course> viewCourse(@QueryParam("studentId") int studentId) throws  SQLException {

		return registrationInterface.viewCourses(studentId);

	}

	/**
	 * Method handles API request to view the list of registered courses for student
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */

	@GetMapping(value = "/viewRegisteredCourses", produces = MediaType.APPLICATION_JSON)
	public List<Course> viewRegisteredCourse(@QueryParam("studentId") int studentId) throws ValidationException, SQLException {

		return registrationInterface.viewRegisteredCourses(studentId);
	}

	@PostMapping(value = "/make_payment", produces = MediaType.APPLICATION_JSON)
	public Response make_payment(@QueryParam("studentId") int studentId, @QueryParam("paymentMode") int paymentMode)
			throws ValidationException, SQLException {
		double fee = registrationInterface.calculateFee(studentId);

		fee = registrationInterface.calculateFee(studentId);
		logger.info("Your total fee  = " + fee);
		ModeOfPayment mode = ModeOfPayment.getModeofPayment(paymentMode);

		logger.info("Your Payment is successful");
		// logger.info("Your transaction id : " + notify.getReferenceId());

		return Response.status(201).entity("Your total fee  = " + fee + "\n" + "Your Payment is successful\n").build();

	}

	/**
	 * Method handles request to display the total fees for student
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */

	@GetMapping(value = "/calculateFees")
	public Response calculateFee(@QueryParam("studentId") int studentId) throws ValidationException, SQLException {

		double fee = registrationInterface.calculateFee(studentId);
		return Response.status(200).entity("Your total fee  = " + fee + "\n").build();
	}

	/**
	 * Method handles request to display the grade card for student
	 * 
	 * @param studentId
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	@GetMapping(value = "/viewGradeCard", produces = MediaType.APPLICATION_JSON)
	public List<StudentGrade> viewGradeCard(@QueryParam("studentId") Integer studentId) throws ValidationException, SQLException {

		List<StudentGrade> grade_card = registrationInterface.viewGradeCard(studentId);
		return grade_card;

	}

}
