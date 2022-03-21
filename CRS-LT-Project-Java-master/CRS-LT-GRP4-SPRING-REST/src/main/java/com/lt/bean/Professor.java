/**
 * 
 */
package com.lt.bean;
import java.util.Date;
/**
 * @author Group-4
 *
 */
public class Professor extends User{
	private int professorId;
	private String department;
	private String designation;
	
	
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
