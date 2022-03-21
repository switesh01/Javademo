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
	      //MySQL database we are using
	      dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	      dataSource.setUrl("jdbc:mysql://localhost:3306/test");//change url
	      dataSource.setUsername("root");//change userid
	      dataSource.setPassword("root");//change pwd
	      //H2 database
	/*
	   dataSource.setDriverClassName("org.h2.Driver");
	   dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
	   dataSource.setUsername("sa");
	   dataSource.setPassword("");*/
	      return dataSource;
	  }
}
