package com.crs.lt.business;

import java.sql.SQLException;
import java.util.Set;

import org.apache.log4j.Logger;

import com.crs.lt.bean.GradeCard;
import com.crs.lt.bean.Student;
import com.crs.lt.dao.StudentDaoImpl;
import com.crs.lt.dao.StudentDaoInterface;

public class StudentOperation implements StudentInterface{

	StudentDaoInterface studentDaoInterface = new StudentDaoImpl();;
	private final Logger log = Logger.getLogger(StudentOperation.class);
	public void register(Student student) throws SQLException {

		studentDaoInterface.addStudent(student);
	}

	public int getStudentById(int studentId) {
		return studentDaoInterface.getStudentById(studentId);
	}



}
