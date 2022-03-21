package com.crs.lt.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringJDBCConfiguration {
	/**
	 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
	 * @category DataSource Necessary values required to establish JDBC connection are set here
	 */

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//MySQL database we are using
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");//change url
		dataSource.setUsername("root");//change userid
		dataSource.setPassword("root");//change pwd

		
		return dataSource;
	}

/**
 * @author Deepikareddy , Bheem , Shiva Amancha, Shiva, Dinesh, Rajnish
 * @category JdbcTemplate 
 */

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	/*	 @Bean
	  public CourseDAO courseDAO(){
	    CourseDAOImpl couDao = new CourseDAOImpl();
	    couDao.setJdbcTemplate(jdbcTemplate());
	    return couDao;
	  }    */

}

