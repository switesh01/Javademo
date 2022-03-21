package com.lt.crs.dto;

import com.lt.crs.constant.Role;

public class ProfessorDto {

	private int id;
	private String name;
	private Role role;
	private String password;
	private String department;
	private String designation;
	
	public ProfessorDto() {
	}
	public ProfessorDto(int id, String name, Role role, String password, String department, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
		this.department = department;
		this.designation = designation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
}
