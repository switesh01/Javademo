package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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



/**
 * @author Group-4
 * 
 */
@Repository
public class AdminDaoOperation implements AdminDaoInterface {
	
	@Autowired
	private ConfigurationJDBC configurationJdbc;

	private static Logger logger = Logger.getLogger(AdminDaoOperation.class);
	private PreparedStatement statement = null;

	@Override
	public void deleteCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException, SQLException{
		Connection connection = configurationJdbc.dataSource().getConnection();
		statement = null;
		try {
			String sql = SQLQueriesConstants.DELETE_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1,courseCode);
			int row = statement.executeUpdate();
			
			logger.info(row + " entries deleted.");
			if(row == 0) {
				logger.error(courseCode + " not in catalog!");
				throw new CourseNotFoundException(courseCode);
			}

			logger.info("Course with courseCode: " + courseCode + " deleted.");
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			throw new CourseNotDeletedException(courseCode);
		}
		
	}

	
	@Override
	public void addCourse(Course course) throws CourseFoundException, SQLException{
		Connection connection = configurationJdbc.dataSource().getConnection();
		statement = null;
		try {
			System.out.println("inside try");
			String sql = SQLQueriesConstants.ADD_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, course.getCourseCode());
			statement.setString(2, course.getCourseName());
			statement.setInt(3, course.getCatalogId());
			//added prof cause its not null
//			statement.setInt(4, course.getProfessorId());
			statement.setInt(4, course.getSeats());
			System.out.println("course.toString(): "+course.toString());
			int row = statement.executeUpdate();
			
			logger.info(row + " course added");
			if(row == 0) {
				logger.error("Course with courseCode: " + course.getCourseCode() + "not added to catalog.");
				throw new CourseFoundException(course.getCourseCode());
			}
			logger.info("Course with courseCode: " + course.getCourseCode() + " is added to catalog."); 
		}catch(SQLException e) {
			logger.error(e.getMessage());
			throw new CourseFoundException(course.getCourseCode());
			
		}
		
	}

	
	@Override
	public List<Student> viewPendingAdmissions() throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		statement = null;
		List<Student> userList = new ArrayList<Student>();
		try {
			
			String sql = SQLQueriesConstants.VIEW_PENDING_ADMISSION_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while(resultSet.next()) {
				
				Student user = new Student();
				user.setUserId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setPassword(resultSet.getString(3));
				user.setRole(Role.stringToName(resultSet.getString(4)));
				user.setStudentId(resultSet.getInt(5));
				System.out.println("dao: "+user.toString());
				userList.add(user);
			}
			
			logger.info(userList.size() + " students have pending-approval.");
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}
		
		return userList;
		
	}


	@Override
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException, SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		statement = null;
		try {
			String sql = SQLQueriesConstants.APPROVE_STUDENT_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1,studentId);
			int row = statement.executeUpdate();
			
			logger.info(row + " student approved.");
			if(row == 0) {
				//logger.error("Student with studentId: " + studentId + " not found.");
				throw new StudentNotFoundForApprovalException(studentId);
			}
			//logger.info("Student with studentId: " + studentId + " approved by admin.");
		}catch(SQLException se) {
			logger.error(se.getMessage());
		}
	}


	@Override
	public void addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException, SQLException{
		Connection connection = configurationJdbc.dataSource().getConnection();
		statement = null;
		try {
			
			String sql = SQLQueriesConstants.ADD_USER_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, user.getUserId());
			statement.setString(2, user.getName());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getRole().toString());

			int row = statement.executeUpdate();
			
			logger.info(row + " user added.");
			if(row == 0) {
				logger.error("User with userId: " + user.getUserId() + " not added.");
				throw new UserNotAddedException(user.getUserId()); 
			}

			logger.info("User with userId: " + user.getUserId() + " added."); 
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			throw new UserIdAlreadyInUseException(user.getUserId());
			
		}
		
	}


	@Override
	public void addProfessor(Professor professor) throws UserIdAlreadyInUseException, ProfessorNotAddedException, SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		try {
			
			this.addUser(professor);
			System.out.println("dao: after add user: "+professor.toString());
			
		}catch (UserNotAddedException e) {
			
			logger.error(e.getMessage());
			throw new ProfessorNotAddedException(professor.getUserId());
			
		}catch (UserIdAlreadyInUseException e) {
			
			logger.error(e.getMessage());
			throw e;
			
		}
		
		statement = null;
		try {
			System.out.println("inside 2nd try");
			String sql = SQLQueriesConstants.ADD_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1, professor.getUserId());
			statement.setString(2, professor.getDepartment());
			statement.setString(3, professor.getDesignation());
			System.out.println("dao: add professor: "+professor.toString()+" "+professor.getUserId());
			int row = statement.executeUpdate();

			logger.info(row + " professor added.");
			if(row == 0) {
				logger.error("Professor with professorId: " + professor.getUserId() + " not added.");
				throw new ProfessorNotAddedException(professor.getUserId());
			}
			
			logger.info("Professor with professorId: " + professor.getUserId() + " added."); 
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			throw new UserIdAlreadyInUseException(professor.getUserId());
			
		} 
		
	}
	

	@Override
	public void assignCourse(String courseCode, int professorId) throws CourseNotFoundException, UserNotFoundException, SQLException{
		Connection connection = configurationJdbc.dataSource().getConnection();
		statement = null;
		try {
			String sql = SQLQueriesConstants.ASSIGN_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			
			statement.setInt(1,professorId);
			statement.setString(2,courseCode);
			int row = statement.executeUpdate();
			
			logger.info(row + " course assigned.");
			if(row == 0) {
				logger.error(courseCode + " not found");
				throw new CourseNotFoundException(courseCode);
			}
			
			logger.info("Course with courseCode: " + courseCode + " is assigned to professor with professorId: " + professorId + ".");
		
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			throw new UserNotFoundException(professorId);
			
		}
		
	}
	

	public List<Course> viewCourses(int catalogId) throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		statement = null;
		List<Course> courseList = new ArrayList<>();
		try {
			
			String sql = SQLQueriesConstants.VIEW_COURSE_QUERY;
			statement = connection.prepareStatement(sql);
			statement.setInt(1, catalogId);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Course course = new Course();
				course.setCourseCode(resultSet.getString(1));
				course.setCourseName(resultSet.getString(2));
				course.setProfessorId(resultSet.getInt(3));
				courseList.add(course);
				
			}
			
			logger.info(courseList.size() + " courses in catalogId: " + catalogId + ".");
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}
		
		return courseList; 
		
	}
	

	@Override
	public List<Professor> viewProfessors() throws SQLException {
		Connection connection = configurationJdbc.dataSource().getConnection();
		statement = null;
		List<Professor> professorList = new ArrayList<>();
		try {
			
			String sql = SQLQueriesConstants.VIEW_PROFESSOR_QUERY;
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				
				Professor professor = new Professor();
				professor.setUserId(resultSet.getInt(1));
				professor.setName(resultSet.getString(2));
				professor.setDepartment(resultSet.getString(4));
				professor.setDesignation(resultSet.getString(5));
				professor.setRole(Role.PROFESSOR);
				professor.setPassword("*********");
				professorList.add(professor);
				
			}
			
			logger.info(professorList.size() + " professors in the institute.");
			
		}catch(SQLException se) {
			
			logger.error(se.getMessage());
			
		}
		return professorList;
	}
}
