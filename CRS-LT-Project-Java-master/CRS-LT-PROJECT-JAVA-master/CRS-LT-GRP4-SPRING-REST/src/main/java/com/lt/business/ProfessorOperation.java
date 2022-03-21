package com.lt.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.EnrolledStudent;
import com.lt.bean.Student;
import com.lt.constant.Grade;
import com.lt.constant.SQLQueriesConstants;
import com.lt.dao.ProfessorDaoInterface;
import com.lt.dao.ProfessorDaoOperation;
import com.lt.exception.GradeNotAddedException;


/**
 * 
 * @author Group-4
 *
 */
public class ProfessorOperation implements ProfessorInterface {
	
	private static ProfessorOperation instance=null;
	ProfessorDaoInterface professorDAOInterface=ProfessorDaoOperation.getInstance();
	private ProfessorOperation()
	{

	}
	
	
	public static ProfessorOperation getInstance()
	{
		if(instance==null)
		{
			
			synchronized(ProfessorOperation.class){
				instance=new ProfessorOperation();
			}
		}
		return instance;
	}
	

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
