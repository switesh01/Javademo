/**
 * 
 */
package com.lt.crs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.crs.model.Course;

/**
 * @author Group-4
 *
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

	@Query(value = "select course.course_code,course.course_name,registered_course.grade from course inner join registered_course on course.course_code = registered_course.course_code where registered_course.student_id = :studentId",
			nativeQuery = true)
	public List<Object[]> viewGradeCard(@Param("studentId") int studentId);
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