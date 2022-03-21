package com.crs.lt.dao;

import java.sql.SQLException;
import java.util.List;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;

public interface ProfessorDaoInterface {

	public void addProfessor(Professor professor) throws SQLException;
	public List<Course> viewCoursesByProfessor(int professorId) throws SQLException;
	public void addrGrade(int studentId, String courdeCode, String grade) throws SQLException;
	public String getProfessorById(int professorId) throws SQLException;
	public List<String> viewAllProfessors() throws SQLException;
}
