package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Student;
import com.lt.bean.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		User student = new Student();
		student.setPassword(resultSet.getString("password"));
//		student.setUserId(resultSet.getInt("user_id"));
		return student;
	}
}
