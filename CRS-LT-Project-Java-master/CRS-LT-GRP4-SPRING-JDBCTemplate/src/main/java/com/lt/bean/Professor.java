/**
 * 
 */
package com.lt.bean;

import com.lt.constant.Role;

/**
 * @author Group-4
 *
 */
public class Professor extends User{
	private int professorId;
	private String department;
	private String designation;
	
	public Professor() {
		
	}
	
	public Professor(int userId, String name, Role role, String password, int professorId, String department,
			String designation) {
		super(userId, name, role, password);
		this.professorId = professorId;
		this.department = department;
		this.designation = designation;
	}

	public int getProfessorId() {
		return professorId;
	}


	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}


	public String getDesignation() {
		return designation;
	}
	
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	public String getDepartment() {
		return department;
	}
	
	
	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Professor [department=" + department + ", designation=" + designation + ", professorId="+ professorId + "]";
	}
	
}
