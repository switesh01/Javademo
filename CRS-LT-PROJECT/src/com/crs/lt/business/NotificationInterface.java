package com.crs.lt.business;

import com.crs.lt.bean.Payment;

public interface NotificationInterface {
	
	public void sendNotification(Payment payment, String message);

}
