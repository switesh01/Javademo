/**
 * 
 */
package com.lt.crs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.lt.crs.constant.Role;

/**
 * 
 * @author Group-4
 * 
 */
@Entity
@Table(name = "STUDENT")
public class Student {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int studentId;
	
	@Column(name = "batch")
	private int batch;
	
	@Column(name = "branch")
	private String branchName;
	
	@Column(name = "is_approved")
	private boolean isApproved;
	
//	@OneToOne
//	@JoinColumn(name = "user_id", insertable = false, updatable = false)
//	@MapsId
//	private User user;
	
	public Student(int userId, String name, Role role, String password, String branchName,int studentId,int batch,boolean isApproved) {
//		super(userId, name,  role, password);
		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.isApproved = isApproved;
	}
	
	public Student(int userId, String name, Role role, String password, int studentId,String branchName,int batch,boolean isApproved) {
//		super(userId, name, role, password);
		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.branchName = branchName;
		this.isApproved = isApproved;
	}
	
	public Student(int studentId,String branchName,int batch,boolean isApproved) {
		this.branchName = branchName;
		this.studentId = studentId;
		this.batch = batch;
		this.branchName = branchName;
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


	@Override
	public String toString() {
		return "Student [branchName=" + branchName + ", studentId=" + studentId + ", batch=" + batch + ", isApproved="
				+ isApproved + "]";
	}
	
	
}
