
package com.lt.bean;


import com.lt.constant.Role;

/**
 * 
 * @author Group-4
 *
 */
public abstract class User {
	private int userId;
	private String name;
	private Role role;
	private String password;

	

	
	public User(int userId, String name, Role role, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.password = password;

	}
	
	
	public User(){
		
	}
	
	
	public int getUserId() {
		return userId;
	}
	
	
	public void setUserId(int userId) {
		this.userId = userId;
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
	
}
