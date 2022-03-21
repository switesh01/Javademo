/**
 * 
 */
package com.lt.crs.controller;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.constant.Role;
import com.lt.crs.dto.StudentDto;
import com.lt.crs.exception.UserNotFoundException;
import com.lt.crs.model.Student;
import com.lt.crs.model.User;
import com.lt.crs.service.StudentInterface;
import com.lt.crs.service.UserInterface;

/**
 * @author sohamslc
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class CRSUserAPI {

	@Autowired
	private UserInterface userInterface;
	
	@Autowired
	private StudentInterface studentInterface;
	
	private static Logger logger=Logger.getLogger(CRSUserAPI.class);
	
	@PostMapping(value = "/registerStudent")
	public ResponseEntity<String> registerStudent(@RequestBody StudentDto studentDto) {
		try {
			System.out.println(studentDto.toString());
			
			User user=new User(studentDto.getId(), studentDto.getName(), Role.STUDENT, studentDto.getPassword());
			int userId=userInterface.register(user);
			
			Student student=new Student(userId, studentDto.getBranchName(), studentDto.getBatch(), false);
			int studentId=studentInterface.register(student);
			return new ResponseEntity<String>("Student registered with ID: "+studentId, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Student not registered", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping(value = "/updatePassword")
	public ResponseEntity<String> updatePassword(@RequestParam("userId") int userId, @RequestParam("newPassword") String newPassword) {
		try {
			System.out.println("controller: "+userId+newPassword);
			if(userInterface.updatePassword(userId, newPassword))
				return new ResponseEntity<String>("Password updated", HttpStatus.OK);
			else
				return new ResponseEntity<String>("User ID is incorrect", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>("User ID is incorrect", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/verifyCreds")
	public ResponseEntity<String> verifyCreds(@RequestParam("userId") int userId, @RequestParam("password") String password) throws SQLException {
		try {
			if(userInterface.verifyCredentials(userId, password)) {
				String role=userInterface.getRole(userId);
				Role userRole=Role.stringToName(role);
				
				switch (userRole) {
				case STUDENT:
					int studentId=studentInterface.getStudentById(userId).getStudentId();
					if(studentInterface.isApproved(studentId))
						return new ResponseEntity<String>("Logged in successfully as STUDENT", HttpStatus.OK);
					break;
				}
				return new ResponseEntity<String>("Logged in successfully as STUDENT", HttpStatus.OK);
			}
			else
				return new ResponseEntity<String>("User ID/Password is incorrect", HttpStatus.NOT_FOUND);
		} catch (UserNotFoundException e) {
			System.out.println("in catch");
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/checkRole")
	public ResponseEntity<String> checkRole(@RequestParam("userId") int userId) {
		try {
			System.out.println(("controller: "+userId));
//			logger.debug("controller: "+userInterface.getRole(userId));
			return new ResponseEntity<String>(userInterface.getRole(userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("User ID is incorrect", HttpStatus.NOT_FOUND);
		}
	}
}
