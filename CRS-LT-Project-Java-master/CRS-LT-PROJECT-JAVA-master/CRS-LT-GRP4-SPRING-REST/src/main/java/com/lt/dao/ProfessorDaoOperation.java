package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.lt.bean.Course;
import com.lt.bean.EnrolledStudent;
import com.lt.bean.Student;
import com.lt.business.StudentOperation;
import com.lt.configuration.ConfigurationJDBC;
import com.lt.constant.SQLQueriesConstants;


/**
 * 
 * @author Group-4
 * Class to implement Professor Dao Operations
 *
 */
public class ProfessorDaoOperation implements ProfessorDaoInterface {
	@Autowired
	   private ConfigurationJDBC configurationJdbc;
	private static ProfessorDaoOperation instance=null;
	private static Logger logger = Logger.getLogger(UserDaoOperation.class);
	DriverManagerDataSource driverManager ;
	/**
	 * Default Constructor
	 */
	private ProfessorDaoOperation()
	{
		
	}
	
	/**
	 * Method to make ProfessorDaoOperation Singleton
	 * @return
	 */
	public static ProfessorDaoOperation getInstance()
	{
		if(instance==null)
		{
			// This is a synchronized block, when multiple threads will access this instance
			synchronized(ProfessorDaoOperation.class){
				instance=new ProfessorDaoOperation();
			}
		}
		return instance;
	}
	
	
	/**
	 * Method to get Courses by Professor Id using SQL Commands
	 * @param userId, prof id of the professor
	 * @return get the courses offered by the professor.
	 * @throws SQLException 
	 */
	@Override
	public List<Course> getCoursesByProfessor(int profId) throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_COURSES);
			
			statement.setInt(1, profId);
			
			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getString("course_code"),results.getString("course_name"),results.getString("professor_id"),results.getInt("seats")));
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList;
		
	}

	/**
	 * Method to view list of enrolled Students using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 * @throws SQLException 
	 */
	@Override
	public List<EnrolledStudent> getEnrolledStudents(int profId) throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		List<EnrolledStudent> enrolledStudents=new ArrayList<EnrolledStudent>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_ENROLLED_STUDENTS);
			statement.setInt(1, profId);
			
			ResultSet results = statement.executeQuery();
			while(results.next())
			{
				//public EnrolledStudent(String courseCode, String courseName, int studentId) 
				enrolledStudents.add(new EnrolledStudent(results.getString("course_code"),results.getString("course_name"),results.getInt("student_id")));
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return enrolledStudents;
	}
	
	/**
	 * Method to Grade a student using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code for the corresponding 
	 * @return: returns the status after adding the grade
	 * @throws SQLException 
	 */
	public Boolean addGrade(int studentId,String courseCode,String grade) throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.ADD_GRADE);
			
			statement.setString(1, grade);
			statement.setString(2, courseCode);
			statement.setInt(3, studentId);
			
			int row = statement.executeUpdate();
			
			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	

	/**
	 * Method to Get professor name by id
	 * @param profId
	 * @return Professor Id in string
	 * @throws SQLException 
	 */
	@Override
	public String getProfessorById(String profId) throws SQLException
	{
		String prof_Name = null;
		Connection connection = configurationJdbc.dataSource().getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_PROF_NAME);
			
			statement.setString(1, profId);
			ResultSet rs = statement.executeQuery();
			rs.next();
			
			prof_Name = rs.getString(1);
			
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			try 
			{
				connection.close();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		return prof_Name;
	}
}
