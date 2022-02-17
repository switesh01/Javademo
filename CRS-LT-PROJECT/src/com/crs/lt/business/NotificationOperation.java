package com.crs.lt.business;

import java.sql.SQLException;

import com.crs.lt.bean.Payment;
import com.crs.lt.dao.NotificationDaoImpl;
import com.crs.lt.dao.NotificationDaoInterface;

public class NotificationOperation {
	
	NotificationDaoInterface notificationDaoInterface =new NotificationDaoImpl();
	public void sendNotification(Payment payment,String message
			 )  throws SQLException, ClassNotFoundException{

		 notificationDaoInterface.sendNotification(payment, message);
	}

}
