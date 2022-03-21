package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.configuration.ConfigurationJDBC;
import com.lt.constant.Role;
import com.lt.constant.SQLQueriesConstants;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotDeletedException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotAddedException;
import com.lt.exception.StudentNotFoundForApprovalException;
import com.lt.exception.UserIdAlreadyInUseException;
import com.lt.exception.UserNotAddedException;
import com.lt.exception.UserNotFoundException;
import com.lt.mapper.AdminPendingAdmissionsMapper;



/**
 * @author Group-4
 * 
 */
@Repository
@Transactional
public class AdminDaoOperation implements AdminDaoInterface {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void deleteCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException, SQLException{
		jdbcTemplate.update(SQLQueriesConstants.DELETE_COURSE_QUERY,courseCode);
	}

	@Override
	public void addCourse(Course course) throws CourseFoundException, SQLException{
		jdbcTemplate.update(SQLQueriesConstants.ADD_COURSE_QUERY,course.getCourseCode(),course.getCourseName(),course.getCatalogId(),course.getSeats());
	}

	@Override
	public List<Student> viewPendingAdmissions() throws SQLException {
		return jdbcTemplate.query(SQLQueriesConstants.VIEW_PENDING_ADMISSION_QUERY, (resultSet, rowNum) -> new Student(resultSet.getInt(1), resultSet.getString(2), Role.stringToName(resultSet.getString(3)), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7), resultSet.getBoolean(8)));
	}

	@Override
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException, SQLException {
		jdbcTemplate.update(SQLQueriesConstants.APPROVE_STUDENT_QUERY,studentId);
	}


	@Override
	public int addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException, SQLException{
		return jdbcTemplate.update(SQLQueriesConstants.ADD_USER_QUERY,user.getUserId(),user.getName(),user.getPassword(),user.getRole().toString());
	}

	@Override
	public void addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException, SQLException, UserNotAddedException {
		if (this.addUser(professor) == 1)
			jdbcTemplate.update(SQLQueriesConstants.ADD_PROFESSOR_QUERY,professor.getUserId(),professor.getDepartment(),professor.getDesignation());
	}

	@Override
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException, SQLException{
		jdbcTemplate.update(SQLQueriesConstants.ASSIGN_COURSE_QUERY,professorId,courseCode);
	}
	
	public List<Course> viewCourses(int catalogId) throws SQLException {
		return jdbcTemplate.query(SQLQueriesConstants.VIEW_COURSE_QUERY, new Object[] {catalogId}, (resultSet, rowNum) -> new Course(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
	}

	@Override
	public List<Professor> viewProfessors() throws SQLException {
		return jdbcTemplate.query(SQLQueriesConstants.VIEW_PROFESSOR_QUERY, (resultSet,rowNum) -> new Professor(resultSet.getInt(1), resultSet.getString(2), Role.stringToName(resultSet.getString(3)), resultSet.getString(4), resultSet.getInt(5), resultSet.getString(5), resultSet.getString(6)));
	}
}
