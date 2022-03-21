package com.lt.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.EnrolledStudent;
import com.lt.dao.ProfessorDaoInterface;
import com.lt.exception.GradeNotAddedException;


/**
 * 
 * @author Group-4
 *
 */
@Service
public class ProfessorOperation implements ProfessorInterface {
	
	@Autowired
	private ProfessorDaoInterface professorDAOInterface;

	@Override
	public boolean addGrade(int studentId,String courseCode,String grade) throws GradeNotAddedException {
		try
		{
			professorDAOInterface.addGrade(studentId, courseCode, grade);
		}
		catch(Exception ex)
		{
			throw new GradeNotAddedException(studentId);
		}
		return true;
	}
	

	@Override
	public List<EnrolledStudent> viewEnrolledStudents(int profId) throws SQLException{
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		try
		{
			enrolledStudents=professorDAOInterface.getEnrolledStudents(profId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return enrolledStudents;
	}

	
	
	@Override
	public List<Course> getCourses(int profId) throws Exception {
		//call the DAO class
		//get the courses for the professor
		List<Course> coursesOffered=new ArrayList<Course>();
		try
		{
			coursesOffered=professorDAOInterface.getCoursesByProfessor(profId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return coursesOffered;
	}
	
	
	@Override
	public String getProfessorById(String profId) throws SQLException
	{
		return professorDAOInterface.getProfessorById(profId);
	}
}
