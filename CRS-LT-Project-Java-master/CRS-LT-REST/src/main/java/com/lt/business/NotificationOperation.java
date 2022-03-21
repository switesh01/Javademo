package com.crs.lt.business;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.crs.lt.constant.ModeOfPayment;
import com.crs.lt.constant.NotificationType;
import com.crs.lt.dao.NotificationDaoInterface;
import com.crs.lt.dao.NotificationDaoOperation;

/**
 * 
 * @author Group-4
 */
public class NotificationOperation implements NotificationInterface {

	private static volatile NotificationOperation instance=null;
	NotificationDaoInterface notificationDaoInterface=NotificationDaoOperation.getInstance();
	private static Logger logger = Logger.getLogger(NotificationOperation.class);
	private NotificationOperation()
	{

	}
	
	
	public static NotificationOperation getInstance()
	{
		if(instance==null)
		{
			synchronized(NotificationOperation.class){
				instance=new NotificationOperation();
			}
		}
		return instance;
	}
	
	
	@Override
	public int sendNotification(NotificationType type, int studentId,ModeOfPayment modeOfPayment,double amount) {
		int notificationId=0;
		try
		{
			notificationId=notificationDaoInterface.sendNotification(type, studentId,modeOfPayment,amount);
			
		}
		catch(SQLException ex)
		{
			logger.error("Error occured "+ex.getMessage());
		}
		return notificationId;
	}

	
	@Override
	public UUID getReferenceId(int notificationId) {
		return null;
	}

}
