package com.crs.lt.business;

import java.util.UUID;

import com.crs.lt.constant.ModeOfPayment;
import com.crs.lt.constant.NotificationType;

/**
 * 
 * @author Group-4
 */
public interface NotificationInterface {
	
	
	public int sendNotification(NotificationType type,int studentId,ModeOfPayment modeOfPayment,double amount);
	
	public UUID getReferenceId(int notificationId); 
}
