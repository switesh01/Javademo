/**
 * 
 */
package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.crs.lt.bean.Student;

/**
 * @author user218
 *
 */
public class StudentDaoImpl implements StudentDaoInterface{

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	static final String USER = "root";
	static final String PASS = "root";
	Connection conn=null;
	PreparedStatement  stmt=null;
	ResultSet rs=null;

	public void addStudent(Student student) throws SQLException {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "insert into user values(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, student.getUserId());
			stmt.setString(2, student.getName());
			stmt.setString(3, student.getRole());
			int row = stmt.executeUpdate();
			if (row == 1) {

				String sql1 = "insert into student values(?,?,?,?)";
				stmt = conn.prepareStatement(sql1);
				stmt.setInt(1, student.getStudentId());
				stmt.setString(2, student.getBranchName());
				stmt.setInt(3, student.getBatch());
				stmt.setBoolean(4, false);
				System.out.println("Number of Records got inserted:::"
						+ stmt.executeUpdate());
			}
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

	public int getStudentById(int studentId) {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			String sql = "select studentId from student where userId = ?";
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt("studentId");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}


	}
