package com.crs.lt.business;

import java.sql.SQLException;
import java.util.Set;

import com.crs.lt.bean.GradeCard;
import com.crs.lt.bean.Student;

public interface StudentInterface {

	public void register(Student student) throws SQLException;

	public int getStudentById(int studentId);

}
