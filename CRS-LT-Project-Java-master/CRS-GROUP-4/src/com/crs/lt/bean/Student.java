/**
 * 
 */
package com.crs.lt.bean;

import com.crs.lt.constant.Role;

/**
 * 
 * @author Group-4
 * 
 */
public class Student extends User {
	private String branchName;
	private int studentId;
	private int batch;
	private boolean isApproved;
	
	
	
	public Student(int userId, String name, Role role, String password, String branchName,int studentId,int batch,boolean isApproved) {
		super(userId, name,  role, password);
		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.isApproved = isApproved;
	}
	
	
	public Student() {
		
	}

	public String getBranchName() {
		return branchName;
	}
	
	
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public int getStudentId() {
		return studentId;
	}
	
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	

	public int getBatch() {
		return batch;
	}
	
	
	public void setBatch(int batch) {
		this.batch = batch;
	}
	
	
	public boolean isApproved() {
		return isApproved;
	}

	
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
