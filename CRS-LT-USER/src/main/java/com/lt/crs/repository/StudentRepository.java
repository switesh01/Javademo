/**
 * 
 */
package com.lt.crs.repository;

import java.sql.SQLException;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.crs.model.Student;

/**
 * 
 * @author Group-4
 * Interface for Student Operations
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	/**
	 * Method to add student to database
	 * @param student: student object containing all the fields
	 * @return true if student is added, else false
	 * @throws StudentNotRegisteredException
	 * @throws SQLException 
	 */
//	public int addStudent(Student student) throws StudentNotRegisteredException;
	
	/**
	 * Method to retrieve Student Id from User Id
	 * @param userId
	 * @return Student Id
	 * @throws SQLException 
	 */
//	public int getStudentId(int userId);
	
	/**
	 * Method to check if Student is approved
	 * @param studentId
	 * @return boolean indicating if student is approved
	 * @throws SQLException 
	 */
	@Query("select s.isApproved from Student s where s.studentId = :studentId")
	public boolean isApproved(@Param("studentId") int studentId);
}
