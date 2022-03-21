package com.lt.crs.dto;

import javax.persistence.Column;

import com.lt.crs.constant.Role;

public class StudentDto {

    private int id;
	private String name;
	private Role role;
	private String password;
    private int batch;
	private String branchName;
	
	private boolean isApproved;
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
	public int getBatch() {
		return batch;
	}
	public void setBatch(int batch) {
		this.batch = batch;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public boolean isApproved() {
		return isApproved;
	}
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", role=" + role + ", password=" + password + ", batch="
				+ batch + ", branchName=" + branchName + ", isApproved=" + isApproved + "]";
	}
	
	
}
