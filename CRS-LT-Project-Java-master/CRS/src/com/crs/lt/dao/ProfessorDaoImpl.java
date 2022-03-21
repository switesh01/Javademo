package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;

/**
 * @author sohamslc
 *
 */
public class ProfessorDaoImpl implements ProfessorDaoInterface {

	private static Logger logger = Logger.getLogger(ProfessorDaoImpl.class);
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	static final String USER = "root";
	static final String PASS = "root";
	Connection conn=null;
	PreparedStatement  stmt=null;
	ResultSet rs=null;
	private static int count=0;
	private final Logger log = Logger.getLogger(ProfessorDaoImpl.class);
	@Override
	public void addProfessor(Professor professor) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt=conn.prepareStatement("insert into professor values(?,?,?)");
			stmt.setInt(1, professor.getProfessorId());
			stmt.setString(2, professor.getDepartment());
			stmt.setString(3, professor.getDesignation());
			
			if(stmt.executeUpdate() > 0)
			    logger.debug("Professor added: "+getProfessorById(professor.getProfessorId()));
			else
				logger.debug("Error occured while trying to add professor");
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error("Exception handled: "+e.getMessage());
		} finally {
			stmt.close();
			conn.close();
		}
	}
	@Override
	public List<Course> viewCoursesByProfessor(int professorId) throws SQLException {
		List<Course> courses=new ArrayList<Course>();
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt=conn.prepareStatement("select * from course where professor_id = ?");
			stmt.setInt(1, professorId);
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				Course course=new Course();
				
				course.setCourseCode(rs.getString(1));
				course.setCourseName(rs.getString(2));
				course.setCatalogId(rs.getInt(3));
				course.setSeats(rs.getInt(4));
				course.setCourseFee(rs.getFloat(5));
				
				courses.add(course);
			}
			logger.debug(courses);
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error("Exception handled: "+e.getMessage());
		} finally {
			stmt.close();
			conn.close();
		}
		return courses;
	}
	@Override
	public void addrGrade(int studentId, String courdeCode, String grade) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt=conn.prepareStatement("update registered_course set grade = ? where student_id = ?, course_code = ?");
			stmt.setString(1, grade);
			stmt.setInt(2, studentId);
			stmt.setString(3, courdeCode);
			
			if(stmt.executeUpdate() > 0)
				logger.debug("Grade added: "+grade);
			else
				logger.debug("Error occured while trying to add grade");
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error("Exception handled: "+e.getMessage());
		} finally {
			stmt.close();
			conn.close();
		}
	}
	@Override
	public String getProfessorById(int professorId) throws SQLException {
		String professor = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			
			stmt=conn.prepareStatement("select user_name from user where user_id = ?");
			stmt.setInt(1, professorId);
			rs=stmt.executeQuery();
			if(rs.next())
				professor=rs.getString("user_name");
			logger.debug("Professor name: "+professor);
			
			stmt.close();
			conn.close();
		} catch (Exception e) {
			logger.error("Exception handled: "+e.getMessage());
		} finally {
			stmt.close();
			conn.close();
		}
		return professor;
	}
	@Override
	public List<String> viewAllProfessors() throws SQLException {
		try {
			List<String> professorList = new ArrayList<String>();
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS); // connection
			String sql = "select * from user where role ='Professor'";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				professorList.add(rs.getString("user_name"));
			}
			//System.out.println("list of professor" +professorList);
			logger.debug("Professors: "+professorList);
			
			return professorList;
		} catch (Exception e) {
			logger.error("Exception handled: "+e.getMessage());
		}
		finally {
			stmt.close();
			conn.close();
		}

		return null;
	}
	
}