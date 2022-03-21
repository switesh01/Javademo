package com.lt.restController;

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

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.business.AdminInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotDeletedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotAddedException;
import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.exception.UserIdAlreadyInUseException;
import com.lt.exception.UserNotAddedException;
import com.lt.exception.UserNotFoundException;

/**
 * @author sohamslc
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class CRSAdminAPI {

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
	public ResponseEntity<String> addProfessor(@RequestBody Professor professor) throws UserNotAddedException {
		try {
			System.out.println("try1");
			adminOperation.addProfessor(professor);
			System.out.println("try2");
			return new ResponseEntity<String>("Professor with professorId: " + professor.getUserId() + " added", HttpStatus.OK);
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
	public List<Student> viewPendingAdmissions() {
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
			List<Student> studentList = adminOperation.viewPendingAdmissions();
			adminOperation.approveStudent(studentId, studentList);
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
			List<Course> courseList = adminOperation.viewCourses(1);
			adminOperation.addCourse(course, courseList);
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
	public List<Professor> viewAllProfessors() {
		try {
			System.out.println(adminOperation.viewPendingAdmissions());
			return adminOperation.viewProfessors();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}