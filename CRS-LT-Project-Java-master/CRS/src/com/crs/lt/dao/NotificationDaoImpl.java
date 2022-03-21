package com.crs.lt.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.crs.lt.bean.Notification;
import com.crs.lt.bean.Payment;
import com.crs.lt.constant.ModeOfPayment;

public class NotificationDaoImpl implements NotificationDaoInterface{

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/test";

	static final String USER = "root";
	static final String PASS = "root";
	Connection conn=null;
	PreparedStatement  stmt=null;
	ResultSet rs=null;
	private final Logger log = Logger.getLogger(NotificationDaoImpl.class);

	public void sendNotification(Payment payment,String message
			 )  throws SQLException{ 
		
	try{
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		
		String sql = "insert into notification values(?,?)";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, payment.getRefId());
		stmt.setString(2, message);
		
		System.out.println("Number of Records got inserted:::"
				+ stmt.executeUpdate());
		stmt.close();
		conn.close();
	} catch (Exception e) {
		System.out.println(e);
	}
	finally{
		stmt.close();
		conn.close();
	}

	
	}
}
