package com.lt.crs.controller;

import java.sql.SQLException;
import java.util.List;

import javax.websocket.server.PathParam;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constant.Role;
import com.lt.crs.dto.ProfessorDto;
import com.lt.crs.dto.StudentDto;
import com.lt.crs.exception.CourseFoundException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.ProfessorNotAddedException;
import com.lt.crs.exception.StudentNotFoundForApprovalException;
import com.lt.crs.exception.UserIdAlreadyInUseException;
import com.lt.crs.exception.UserNotAddedException;
import com.lt.crs.exception.UserNotFoundException;
import com.lt.crs.model.Course;
import com.lt.crs.model.Professor;
import com.lt.crs.model.Student;
import com.lt.crs.model.User;
import com.lt.crs.repository.AdminRepository;
import com.lt.crs.service.AdminInterface;
import com.lt.crs.service.UserInterface;

/**
 * @author sohamslc
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class CRSAdminAPI {

	@Autowired
	private UserInterface userInterface;
	
	@Autowired
	private AdminInterface adminOperation;

	/**
	 * /admin/assignCourseToProfessor
	 * REST-service for assigning course to professor
	 * @param courseCode
	 * @param professorId
	 * @return
	 */
	@RequestMapping(value = "/assignCourseToProfessor", method = RequestMethod.PUT)
	public ResponseEntity<String> assignCourseToProfessor(@PathParam("professorId") int professorId, @PathParam("courseCode") String courseCode) {
			try {
				adminOperation.assignCourse(courseCode, professorId);
				return new ResponseEntity<String>("Course code " + courseCode + " assigned to professor id " + professorId, HttpStatus.OK);
			} catch (CourseNotFoundException | UserNotFoundException | SQLException e) {
				return new ResponseEntity<String>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
			}
	}

	/**
	 * /admin/registerProfessor
	 * REST-service for adding a new professor
	 * @param professor
	 * @return
	 * @throws UserNotAddedException 
	 */
	@PostMapping("/registerProfessor")
	public ResponseEntity<String> addProfessor(@RequestBody ProfessorDto professorDto) throws UserNotAddedException {
		try {
			User user=new User(professorDto.getId(), professorDto.getName(), Role.PROFESSOR, professorDto.getPassword());
			int userId=userInterface.register(user);
			
			Professor professor=new Professor(userId, professorDto.getDepartment(), professorDto.getDesignation());
			adminOperation.addProfessor(professor);
			System.out.println("try2");
			return new ResponseEntity<String>("Professor with professorId: " + professorDto.getId() + " added", HttpStatus.OK);
		} catch (ProfessorNotAddedException | UserIdAlreadyInUseException | SQLException e) {
			System.out.println("catch1");
			return new ResponseEntity<String>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * /admin/viewPendingAdmissions
	 * REST-service for getting all pending-approval of students
	 * @return
	 */
	@GetMapping("/viewPendingAdmissions")
	public List<StudentDto> viewPendingAdmissions() {
		try {
			System.out.println(adminOperation.viewPendingAdmissions());
			return adminOperation.viewPendingAdmissions();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * /admin/approveStudent
	 * REST-service for approving the student admission
	 * @param studentId
	 * @return
	 * @throws  
	 */
	@PutMapping("/approveStudent")
	public ResponseEntity<String> approveStudent(@RequestParam("studentId") int studentId) {
		try {
			adminOperation.approveStudent(studentId);
			return new ResponseEntity<String>("Student with studentId: " + studentId + " approved", HttpStatus.OK);
		} catch (StudentNotFoundForApprovalException | SQLException e) {
			return new ResponseEntity<String>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * /admin/viewCoursesInCatalog
	 * REST-service for getting courses in the catalog
	 * @return
	 */
	@GetMapping("/viewCoursesInCatalog")
	public List<Course> viewCoursesInCatalog(@RequestParam("catalogId") int catalogId) {
		try {
			return adminOperation.viewCourses(catalogId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * /admin/deleteCourse
	 * REST-services for dropping a course from catalog
	 * @param courseCode
	 * @return
	 * @throws SQLException 
	 * @throws CourseNotDeletedException 
	 */
	@DeleteMapping("/deleteCourse")
	public ResponseEntity<String> deleteCourse(@RequestParam("courseCode") String courseCode){
		try {
			List<Course> courseList = adminOperation.viewCourses(1);
			adminOperation.deleteCourse(courseCode, courseList);
			return new ResponseEntity<String>("Course with course code " + courseCode + " deleted from catalog", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}
	
	/**
	 * /admin/addCourse
	 * REST-service for adding a new course in catalog
	 * @param course
	 * @return
	 * @throws SQLException 
	 */
	@PostMapping("/addCourse")
	public ResponseEntity<String> addCourse(@RequestBody Course course) {
		try {
			adminOperation.addCourse(course);
			return new ResponseEntity<String>("Course with course code " + course.getCourseCode() + " added to catalog id " + course.getCatalogId(),HttpStatus.OK);
		} catch (CourseFoundException | SQLException e) {
			return new ResponseEntity<String>("Error: "+e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * /admin/viewAllProfessors
	 * REST-service for getting all pending-approval of students
	 * @return
	 */
	@GetMapping("/viewAllProfessors")
	public List<String> viewAllProfessors() {
		try {
			System.out.println(adminOperation.viewPendingAdmissions());
			return adminOperation.viewProfessors();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}