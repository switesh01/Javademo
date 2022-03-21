package com.crs.lt.business;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.crs.lt.bean.Course;
import com.crs.lt.bean.Professor;
import com.crs.lt.dao.ProfessorDaoImpl;
import com.crs.lt.dao.ProfessorDaoInterface;

public class ProfessorOperation implements ProfessorInterface{

	ProfessorDaoInterface professorDao=new ProfessorDaoImpl();
	private final Logger logger = Logger.getLogger(ProfessorOperation.class);
	@Override
	public void addProfessor(Professor professor) throws SQLException {
		professorDao.addProfessor(professor);
	}

	@Override
	public List<Course> viewCoursesByProfessor(int professorId) throws SQLException {
		return professorDao.viewCoursesByProfessor(professorId);
	}

	@Override
	public void addrGrade(int studentId, String courdeCode, String grade) throws SQLException {
		professorDao.addrGrade(studentId, courdeCode, grade);
	}

	@Override
	public String getProfessorById(int professorId) throws SQLException {
		return professorDao.getProfessorById(professorId);
	}

	@Override
	public List<String> viewAllProfessors() throws SQLException {
		return professorDao.viewAllProfessors();
	}

}