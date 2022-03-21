
package com.lt.bean;

import java.util.Date;

/**
 * 
 * @author Group-4
 * 
 */
public class Admin extends User{
	private Date dateOfJoining;

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
}
