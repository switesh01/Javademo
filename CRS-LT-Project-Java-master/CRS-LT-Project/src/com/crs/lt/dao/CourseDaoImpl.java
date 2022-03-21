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
			// System.out.println("Database connected");
			String sql = "insert into course values(?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
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
			conn = DriverManager.getConnection(DB_URL, USER, PASS); // connection
			String sql = "delete  from course where course_code = ?";
			stmt = conn.prepareStatement(sql);
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
			conn = DriverManager.getConnection(DB_URL, USER, PASS); // connection
			String sql = "update  course set course_name = ?, course_fee = ?  where course_code = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseName);
			stmt.setFloat(2, courseFee);
			stmt.setString(3, courseCode);

			System.out.println("Number of Records got updated:::"
					+ stmt.executeUpdate());
			if (stmt.executeUpdate() > 0) {
				rs = stmt
						.executeQuery("select course_code, course_name, course_fee, catalog_id, course_fee,professor_id from course");
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

	public List<Course> viewRegisteredCourses(int StudentId) {
		
		return null;
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
