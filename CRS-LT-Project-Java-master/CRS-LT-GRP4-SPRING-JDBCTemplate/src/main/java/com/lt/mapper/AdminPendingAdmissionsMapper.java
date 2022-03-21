package com.lt.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.constant.Role;

public class AdminPendingAdmissionsMapper implements RowMapper<List<Student>> {

	@Override
	public List<Student> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		List<Student> students=new ArrayList<Student>();
		
		Student student = new Student();
		student.setUserId(resultSet.getInt(1));
		student.setName(resultSet.getString(2));
		student.setPassword(resultSet.getString(3));
		student.setRole(Role.stringToName(resultSet.getString(4)));
		student.setStudentId(resultSet.getInt(5));
		
		students.add(student);
		
		return students;
	}
}
