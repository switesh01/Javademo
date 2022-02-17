/**
 * 
 */
package com.crs.lt.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.crs.lt.bean.Student;

/**
 * @author user218
 *
 */
public interface StudentDaoInterface {
	public void addStudent(Student student) throws SQLException;

	public int getStudentById(int studentId);

}
