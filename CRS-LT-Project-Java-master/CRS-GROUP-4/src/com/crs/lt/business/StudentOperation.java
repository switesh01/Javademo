package com.crs.lt.business;

import org.apache.log4j.Logger;

import com.crs.lt.application.CRSApplication;
import com.crs.lt.bean.Student;
import com.crs.lt.constant.Role;
import com.crs.lt.dao.StudentDaoInterface;
import com.crs.lt.dao.StudentDaoOperation;
import com.crs.lt.exception.StudentNotRegisteredException;

/**
 * 
 * @author Group-4
 *
 */
public class StudentOperation implements StudentInterface {
	
	private static StudentOperation instance=null;
	private static Logger logger = Logger.getLogger(CRSApplication.class);
	StudentDaoInterface studentDaoInterface=StudentDaoOperation.getInstance();

	private StudentOperation()
	{
		
	}
	
	public static StudentOperation getInstance()
	{
		if(instance==null)
		{

			synchronized(StudentOperation.class){
				instance=new StudentOperation();
			}
		}
		return instance;
	}
	
	
	@Override
	public int register(String name,int userId,String password,int batch,String branch) throws StudentNotRegisteredException{
		int studentId;
		try
		{
			//call the DAO class, and add the student record to the DB
			Student newStudent=new Student(userId,name,Role.STUDENT,password,branch,0,batch,false);
			studentId=studentDaoInterface.addStudent(newStudent);
			
		}
		catch(StudentNotRegisteredException ex)
		{
			throw ex;
		}
		return studentId;
	}
	
	
	@Override
	public int getStudentId(int userId) {
		return studentDaoInterface.getStudentId(userId);
	
	}
	
	
	@Override
	public boolean isApproved(int studentId) {
		return studentDaoInterface.isApproved(studentId);
	}


}
