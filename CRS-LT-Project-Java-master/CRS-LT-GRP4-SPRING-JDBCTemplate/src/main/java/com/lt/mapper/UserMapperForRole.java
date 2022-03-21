package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Student;
import com.lt.bean.User;

public class UserMapperForRole implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		System.out.println("mapRow");
		return resultSet.getString("role");
	}
}
