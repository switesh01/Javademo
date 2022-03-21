package com.crs.lt.business;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.crs.lt.bean.Payment;
import com.crs.lt.dao.NotificationDaoImpl;
import com.crs.lt.dao.NotificationDaoInterface;


public class NotificationOperation {
	
	NotificationDaoInterface notificationDaoInterface =new NotificationDaoImpl();
	private final Logger log = Logger.getLogger(NotificationOperation.class);
	public void sendNotification(Payment payment,String message
			 )  throws SQLException, ClassNotFoundException{

		 notificationDaoInterface.sendNotification(payment, message);
	}

}
