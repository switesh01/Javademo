/**
 * 
 */
package com.crs.lt.bean;

import java.util.Date;

/**
 * @author user218
 *
 */
public class Professor extends User{
	private int professorId;
	private String department;
	private String designation;
	private Date doj;
	

	public int getProfessorId() {
		return professorId;
	}
	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", department=" + department + ", designation=" + designation
				+ ", doj=" + doj + "]";
	}
}
