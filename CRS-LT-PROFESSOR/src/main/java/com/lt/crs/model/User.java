
package com.lt.crs.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.lt.crs.constant.Role;

/**
 * 
 * @author Group-4
 *
 */

@Entity
@Table(name = "USER")
public class User {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String name;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role")
	private Role role;
	
	@Column(name = "password")
	private String password;
	
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	private Student student;
//	
//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	private Professor professor;
	
	public User(int userId, String name, Role role, String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.role = role;
		this.password = password;

	}
	
	public User(){}
	
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

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", role=" + role + ", password=" + password + "]";
	}
	
}
