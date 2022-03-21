package com.crs.lt.dao;

import java.util.List;

import com.crs.lt.model.Employee;

public interface EmployeeDAO {
	 /** 
	    * This is the method to be used to initialize
	    * database resources ie. connection.
	    */
	   
	   public void create(String name, Integer age);
	   
	   public Employee getEmployee(Integer id);
	  
	   public List<Employee> listEmployees();
	  
	   public void delete(Integer id);
	  
	   public void update(Integer id, Integer age);



}

