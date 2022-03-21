package com.lt.business;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Student;
import com.lt.constant.Role;
import com.lt.dao.StudentDaoInterface;
import com.lt.exception.StudentNotRegisteredException;

/**
 * 
 * @author Group-4
 *
 */
@Service
public class StudentOperation implements StudentInterface {

	@Autowired
	StudentDaoInterface studentDaoInterface;

//	private StudentOperation()
//	{
//		
//	}
//	
//	public static StudentOperation getInstance()
//	{
//		if(instance==null)
//		{
//
//			synchronized(StudentOperation.class){
//				instance=new StudentOperation();
//			}
//		}
//		return instance;
//	}

	@Override
	public int register(String name, int userId, String password, int batch, String branch)
			throws StudentNotRegisteredException, SQLException {
		int studentId;
		try {
			Student newStudent = new Student(userId, name, Role.STUDENT, password, branch, 0, batch, false);
			studentId = studentDaoInterface.addStudent(newStudent);
		} catch (StudentNotRegisteredException ex) {
			throw ex;
		}
		return studentId;
	}

	@Override
	public int getStudentId(int userId) throws SQLException {
		return studentDaoInterface.getStudentId(userId);

	}

	@Override
	public boolean isApproved(int studentId) throws SQLException {
		return studentDaoInterface.isApproved(studentId);
	}

}
