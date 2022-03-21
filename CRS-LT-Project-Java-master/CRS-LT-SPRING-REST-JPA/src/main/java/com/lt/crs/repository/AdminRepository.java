/**
 * 
 */
package com.lt.crs.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.crs.model.Course;
import com.lt.crs.model.Professor;
import com.lt.crs.model.Student;
import com.lt.crs.model.User;
import com.lt.crs.model.Admin;
import com.lt.crs.exception.CourseFoundException;
import com.lt.crs.exception.CourseNotDeletedException;
import com.lt.crs.exception.CourseNotFoundException;
import com.lt.crs.exception.ProfessorNotAddedException;
import com.lt.crs.exception.StudentNotFoundForApprovalException;
import com.lt.crs.exception.UserIdAlreadyInUseException;
import com.lt.crs.exception.UserNotAddedException;
import com.lt.crs.exception.UserNotFoundException;

/**
 * @author Group-4
 *
 */

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query(value = "delete from course where course_code = :courseCode",nativeQuery = true)
	public void deleteCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException, SQLException;

	@Query(value = "insert into Course(course_code, course_name, catalog_id, seats) values (:courseCode, :courseName, :catalogid, :seats)",nativeQuery = true)
	public void addCourse(@Param("courseCode") String courseCode, String courseName, int catalogid, int seats) throws CourseFoundException, SQLException;

	@Query(value = "select user_id, user_name, role, password, student_id, branch, batch, is_approved from student inner join user on student.student_id=user.user_id where is_approved = 0",
			nativeQuery = true)
	public List<Object[]> viewPendingAdmissions() throws SQLException;

	@Modifying
	@Query(value = "update Student set is_approved = 1 where student_id = ?",nativeQuery = true)
	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException, SQLException;

//	@Query("")
//	public void addProfessor(Professor professor)
//			throws ProfessorNotAddedException, UserIdAlreadyInUseException, SQLException, UserNotAddedException;

//	@Query("")
//	public int addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException, SQLException;

	@Modifying
	@Query("update Course set professor_id = :professorId where course_code = :courseCode")
	public void assignCourse(@Param("courseCode") String courseCode,@Param("professorId") int professorId)
			throws CourseNotFoundException, UserNotFoundException, SQLException;

	@Query(value = "select * from Course where catalog_id = :catalogId", nativeQuery = true)
	public List<Object[]> viewCourses(@Param("catalogId") int catalogId) throws SQLException;

//	@Query("")
//	public List<Professor> viewProfessors() throws SQLException;
}





























/*
public interface AdminRepository {

	public void deleteCourse(String courseCode) throws CourseNotFoundException, CourseNotDeletedException, SQLException;

	public void addCourse(Course course) throws CourseFoundException, SQLException;

	public List<Student> viewPendingAdmissions() throws SQLException;

	public void approveStudent(int studentId) throws StudentNotFoundForApprovalException, SQLException;

	public void addProfessor(Professor professor)
			throws ProfessorNotAddedException, UserIdAlreadyInUseException, SQLException, UserNotAddedException;

	public int addUser(User user) throws UserNotAddedException, UserIdAlreadyInUseException, SQLException;

	public void assignCourse(String courseCode, int professorId)
			throws CourseNotFoundException, UserNotFoundException, SQLException;

	public List<Course> viewCourses(int catalogId) throws SQLException;

	public List<Professor> viewProfessors() throws SQLException;
}
*/