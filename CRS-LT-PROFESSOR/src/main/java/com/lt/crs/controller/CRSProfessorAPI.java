package com.lt.crs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lt.crs.model.Course;
import com.lt.crs.model.EnrolledStudent;
import com.lt.crs.service.ProfessorInterface;

/**
 * @author sohamslc
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/professor")
public class CRSProfessorAPI {
	
	@Autowired
	ProfessorInterface professorInterface;

	@GetMapping(value = "/getEnrolledStudents")
	public List<EnrolledStudent> viewEnrolledStudents(@RequestParam("professorId") int profId) {
		System.out.println(profId);
		List<EnrolledStudent> students = new ArrayList<EnrolledStudent>();
		try {
			students = professorInterface.viewEnrolledStudents(profId);
		} catch (Exception ex) {
			return null;
		}
		return students;
	}

	@GetMapping(value = "/getCourses")
	public List<Course> getCourses(@RequestParam("professorId") int profId) {
		List<Course> courses = new ArrayList<Course>();
		try {
			courses = professorInterface.getCourses(profId);
		} catch (Exception ex) {
			return null;
		}
		return courses;
	}

	@PutMapping(value = "/addGrade")
	public ResponseEntity<String> addGrade(@RequestParam("professorId") int profId, @RequestParam("studentId") int studentId, @RequestParam("courseCode") String courseCode, @RequestParam("grade") String grade) {
		try {
//			List<EnrolledStudent> enrolledStudents = new ArrayList<EnrolledStudent>();
//			enrolledStudents = professorInterface.viewEnrolledStudents(profId);
//			List<Course> coursesEnrolled = new ArrayList<Course>();
//			coursesEnrolled = professorInterface.getCourses(profId);
		    professorInterface.addGrade(studentId, courseCode, grade);
		} catch (Exception ex) {
			return ResponseEntity.status(500).body("Something went wrong, Please Try Again! ");
		}
		return ResponseEntity.status(200).body("Grade updated for student: " + studentId);
	}

}