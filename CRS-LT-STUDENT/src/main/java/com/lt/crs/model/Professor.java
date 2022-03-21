/**
 * 
 */
package com.lt.crs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lt.crs.constant.Role;

/**
 * @author Group-4
 *
 */
@Entity
@Table(name = "PROFESSOR")
public class Professor {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "professor_id")
	private int professorId;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "designation")
	private String designation;
	
//	@OneToOne
//	@JoinColumn(name = "user_id")
//	@MapsId
//	private User user;
	
	public Professor() {
		
	}
	
	public Professor(int professorId, String department, String designation) {
		this.professorId = professorId;
		this.department = department;
		this.designation = designation;
	}
	
	public Professor(int userId, String name, Role role, String password, int professorId, String department,
			String designation) {
//		super(userId, name, role, password);
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
