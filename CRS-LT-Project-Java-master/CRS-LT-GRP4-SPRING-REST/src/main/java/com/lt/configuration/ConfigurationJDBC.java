/**
 * 
 */
package com.lt.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author user218
 *
 */
@Configuration
public class ConfigurationJDBC {

	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//	    dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		/*
		 * dataSource.setDriverClassName("org.h2.Driver");
		 * dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		 * dataSource.setUsername("sa"); dataSource.setPassword("");
		 */
		return dataSource;
	}
}
