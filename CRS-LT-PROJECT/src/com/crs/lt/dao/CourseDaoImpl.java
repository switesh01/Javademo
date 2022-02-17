/**
 * 
 */
package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Payment;
import com.crs.lt.bean.Professor;
import com.crs.lt.bean.StudentGrade;
import com.crs.lt.bean.User;
import com.crs.lt.constant.SQLQueriesConstants;


/**
 * @author user218
 *
 */
public class CourseDaoImpl implements CourseDaoInterface {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	static final String USER = "root";
	static final String PASS = "root";
	Connection conn=null;
	PreparedStatement  stmt=null;
	ResultSet rs=null;
	
	public void registerCourse() {
		// TODO Auto-generated method stub
		
	}
	public void addCourse(Course course) throws SQLException {
		
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS); // connection
			stmt = conn.prepareStatement(SQLQueriesConstants.INSERT_COURSE);
			stmt.setString(1, course.getCourseCode());
			stmt.setString(2, course.getCourseName());
			stmt.setInt(3, course.getCatalogId());
			stmt.setInt(4, course.getSeats());
			stmt.setFloat(5, course.getCourseFee());
			stmt.setInt(6, course.getProfessorId());
			System.out.println("Number of Records got inserted:::"
					+ stmt.executeUpdate());
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		finally{
			stmt.close();
			conn.close();
		}
		
	}


	public void deleteCourse(String courseCode) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS); 
			stmt = conn.prepareStatement(SQLQueriesConstants.DELETE_COURSE);
			stmt.setString(1, courseCode);
			System.out.println("Number of Records deleted:::"
					+ stmt.executeUpdate());
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		
	}

	public Course updateCourse(String courseCode, String courseName,
			float courseFee) throws SQLException {
		try {

			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS); 
			stmt = conn.prepareStatement(SQLQueriesConstants.UPDATE_COURSE);
			stmt.setString(1, courseName);
			stmt.setFloat(2, courseFee);
			stmt.setString(3, courseCode);

			System.out.println("Number of Records got updated:::"
					+ stmt.executeUpdate());
			if (stmt.executeUpdate() > 0) {
				rs = stmt
						.executeQuery(SQLQueriesConstants.SELECT_COURSE);
				Course course = new Course();
				// Professor prof = new Professor();
				User user = new Professor();
				while (rs.next()) {
					course.setCourseCode(rs.getString("course_code"));
					course.setCourseName(rs.getString("course_name"));
					course.setCatalogId(rs.getInt("catalog_id"));
					course.setCourseFee(rs.getFloat("course_fee"));
					user.setUserId(rs.getInt("professor_id"));
					// prof.setProfessorId(user.getUserId());
					course.setProfessorId(user.getUserId());
				}
				return course;
			}
			stmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			stmt.close();
			conn.close();
		}

		return null;
	}

	public List<Course> viewCourse() throws SQLException {
		try {
			List<Course> courseList = new ArrayList<Course>();
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS); // connection
			String sql = "select * from course";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {				
				courseList.add(new Course(rs.getString("course_code"), rs
						.getString("course_name"), rs.getInt("catalog_id"), rs
						.getInt("seats"), rs.getFloat("course_fee"), rs
						.getInt("professor_id")));
			}
			return courseList;
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			stmt.close();
			conn.close();
		}

		return null;
	}

	public List<StudentGrade> viewRegisteredCourses(int StudentId) throws SQLException {
		List<StudentGrade> grade_List = new ArrayList<StudentGrade>();
		try {
			stmt = conn.prepareStatement(SQLQueriesConstants.VIEW_GRADE);
			stmt.setInt(1, StudentId);
			rs = stmt.executeQuery();
			
			while(rs.next())
			{
				String courseCode = rs.getString("courseCode");
				String courseName = rs.getString("courseName");
				String grade = rs.getString("grade");
				StudentGrade obj = new StudentGrade(courseCode, courseName,grade);
				grade_List.add(obj);
				return grade_List;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			stmt.close();
			conn.close();
		}
		return grade_List;
	}

	public List<StudentGrade> viewGradeCard(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Payment makePayment(int studentId, String courseCode) {
		// TODO Auto-generated method stub
		return null;
	}



}
