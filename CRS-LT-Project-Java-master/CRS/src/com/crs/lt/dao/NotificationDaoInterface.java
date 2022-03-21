package com.crs.lt.dao;

import java.sql.SQLException;

import com.crs.lt.bean.Payment;

public interface NotificationDaoInterface {
	
	public void sendNotification(Payment payment, String message) throws SQLException,ClassNotFoundException;

}
