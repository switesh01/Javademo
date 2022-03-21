package com.lt.crs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.crs.exception.GradeNotAddedException;
import com.lt.crs.model.Course;
import com.lt.crs.model.EnrolledStudent;
import com.lt.crs.repository.ProfessorRepository;
import com.lt.crs.repository.RegisteredCourseRepository;
import com.lt.crs.repository.UserRepository;


/**
 * 
 * @author Group-4
 *
 */
@Service
@Transactional
public class ProfessorOperation implements ProfessorInterface {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RegisteredCourseRepository registeredCourseRepository;

	@Override
	public boolean addGrade(int studentId,String courseCode,String grade) throws GradeNotAddedException {
		System.out.println("service: "+studentId+" "+courseCode+" "+grade);
		registeredCourseRepository.addGrade(studentId, courseCode, grade);
		return true;
	}

	@Override
	public List<EnrolledStudent> viewEnrolledStudents(int profId) {
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		for(Object[] obj: professorRepository.getEnrolledStudents(profId)) {
			EnrolledStudent es=new EnrolledStudent();
			es.setCourseCode((String)obj[0]);
			es.setCourseName((String)obj[1]);
			es.setStudentId((int)obj[2]);
			enrolledStudents.add(es);
		}
		return enrolledStudents;
	}

	
	
	@Override
	public List<Course> getCourses(int profId) throws Exception {
		return professorRepository.getCoursesByProfessor(profId);
	}
	
	
	@Override
	public String getProfessorById(int profId) {
		return userRepository.findById(profId).get().getName();
	}
}
