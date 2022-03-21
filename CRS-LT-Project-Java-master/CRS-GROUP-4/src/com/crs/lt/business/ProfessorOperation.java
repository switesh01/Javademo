package com.crs.lt.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.EnrolledStudent;
import com.crs.lt.bean.Student;
import com.crs.lt.constant.Grade;
import com.crs.lt.constant.SQLQueriesConstants;
import com.crs.lt.dao.ProfessorDaoInterface;
import com.crs.lt.dao.ProfessorDaoOperation;
import com.crs.lt.exception.GradeNotAddedException;
import com.crs.lt.utils.DBUtils;

/**
 * 
 * @author Group-4
 *
 */
public class ProfessorOperation implements ProfessorInterface {
	
	private static volatile ProfessorOperation instance=null;
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
	public List<Course> getCourses(int profId) {
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
	public String getProfessorById(String profId)
	{
		return professorDAOInterface.getProfessorById(profId);
	}
}
