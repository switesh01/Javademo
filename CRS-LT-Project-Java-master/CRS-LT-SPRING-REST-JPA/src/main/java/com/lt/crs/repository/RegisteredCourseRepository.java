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
import com.lt.crs.model.RegisteredCourse;
import com.lt.crs.model.Student;

/**
 * 
 * @author Group-4
 * Interface for Admin Dao Operations
 * 
 */
@Repository
public interface RegisteredCourseRepository extends JpaRepository<RegisteredCourse, Integer> {
	/**
	 * Method to Grade a student using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code for the corresponding 
	 * @return: returns the status after adding the grade
	 */
	@Modifying
	@Query(value = "update registered_course set grade = :grade where course_code = :courseCode and student_id = :studentId", nativeQuery = true)
	public void addGrade(@Param("studentId") int studentId,@Param("courseCode") String courseCode,@Param("grade") String grade);
}
