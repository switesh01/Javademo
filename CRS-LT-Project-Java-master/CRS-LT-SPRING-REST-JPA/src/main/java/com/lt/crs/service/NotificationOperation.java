package com.lt.crs.service;

import java.sql.SQLException;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.crs.constant.ModeOfPayment;
import com.lt.crs.constant.NotificationType;
import com.lt.crs.repository.NotificationRepository;

/**
 * 
 * @author Group-4
 */
@Service
public class NotificationOperation implements NotificationInterface {
	
//	private static final Logger logger=Logger.getLogger(NotificationOperation.class);
//
//	@Autowired
//	private NotificationRepository notificationRepository;
//	
//	@Override
//	public int sendNotification(NotificationType type, int studentId,ModeOfPayment modeOfPayment,double amount) {
//		int notificationId=0;
//		try
//		{
//			notificationId=notificationRepository.sendNotification(type, studentId,modeOfPayment,amount);
//		}
//		catch(SQLException ex)
//		{
//			logger.error("Error occured "+ex.getMessage());
//		}
//		return notificationId;
//	}
//	
//	@Override
//	public UUID getReferenceId(int notificationId) {
//		return null;
//	}

}
