/**
 * 
 */
package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.bean.Student;
import com.lt.business.StudentOperation;
import com.lt.configuration.ConfigurationJDBC;
import com.lt.constant.SQLQueriesConstants;
import com.lt.exception.StudentNotRegisteredException;


/**
 * 
 * @author Group-4
 * Class to implement Student Dao Operations
 *
 */

@Repository
public class StudentDaoOperation implements StudentDaoInterface {

	@Autowired
	private ConfigurationJDBC configurationJdbc;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static Logger logger = Logger.getLogger(StudentOperation.class);

	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 * @throws SQLException 
	 */
	@Override
	@Transactional
	public int addStudent(Student student) throws StudentNotRegisteredException, SQLException{
		int studentId=student.getUserId();
		int rowsAffected=jdbcTemplate.update(SQLQueriesConstants.ADD_USER_QUERY,student.getUserId(),student.getName(),student.getPassword(),student.getRole().toString());
		if(rowsAffected==1)
			jdbcTemplate.update(SQLQueriesConstants.ADD_STUDENT,student.getUserId(),student.getBranchName(),student.getBatch(),false);
		return studentId;
	}
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 * @throws SQLException 
	 */
	@Override
	public int getStudentId(int userId) throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.GET_STUDENT_ID);
			statement.setInt(1, userId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getInt("student_id");
			}
				
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		return 0;
	}
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 * @throws SQLException 
	 */
	@Override
	public boolean isApproved(int studentId) throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueriesConstants.IS_APPROVED);
			statement.setInt(1, studentId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next())
			{
				return rs.getBoolean("is_approved");
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}
		
		return false;
	}

}
