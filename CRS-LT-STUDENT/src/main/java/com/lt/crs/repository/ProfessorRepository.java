package com.lt.crs.repository;

import java.sql.SQLException;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.crs.model.Course;
import com.lt.crs.model.EnrolledStudent;
import com.lt.crs.model.Professor;
import com.lt.crs.model.Student;

/**
 * 
 * @author Group-4
 * Interface for Admin Dao Operations
 * 
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
	
	/**
	 * Method to get Courses by Professor Id using SQL Commands
	 * @param userId, prof id of the professor
	 * @return get the courses offered by the professor.
	 */
	@Query(value = "select * from Course where professor_id = :profId", nativeQuery = true)
	public List<Course> getCoursesByProfessor(@Param("profId") int profId);
	
	
	/**
	 * Method to view list of enrolled Students using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	@Query(value = "select course.course_code,course.course_name,registered_course.student_id from course inner join registered_course on course.course_code = registered_course.course_code where course.professor_id = :profId order by course.course_code",
			nativeQuery = true)
	public List<Object[]> getEnrolledStudents(@Param("profId") int profId);
	//List<EnrolledStudent>

	/**
	 * Method to Get professor name by id
	 * @param profId
	 * @return Professor Id in string
	 * @throws SQLException 
	 */
//	public String getProfessorById(String profId) throws SQLException;
}
