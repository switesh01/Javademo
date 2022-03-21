
package com.lt.crs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author Group-4
 * 
 */
@Entity
@Table(name = "ADMIN")
public class Admin {
	
	@Id
	private String adminId;
	
	@Transient
	private Date dateOfJoining;

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
