package com.lt.crs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.crs.constant.Role;
import com.lt.crs.exception.StudentNotRegisteredException;
import com.lt.crs.model.Student;
import com.lt.crs.model.User;
import com.lt.crs.repository.StudentRepository;
import com.lt.crs.repository.UserRepository;

/**
 * 
 * @author Group-4
 *
 */
@Service
@Transactional
public class StudentOperation implements StudentInterface {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public int register(Student student) throws StudentNotRegisteredException {
		Student newStudent = studentRepository.save(student);
		return newStudent.getStudentId();
	}

	@Override
	public Student getStudentById(int userId) {
		return studentRepository.findById(userId).get();
	}

	@Override
	public boolean isApproved(int studentId) {
		return studentRepository.isApproved(studentId);
	}

}
