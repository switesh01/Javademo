package com.crs.lt.application;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.crs.lt.configuration.SpringJDBCConfiguration;
import com.crs.lt.dao.EmployeeDAOImpl;
import com.crs.lt.model.Employee;

@ComponentScan("com.crs.lt.*")
@EnableAutoConfiguration
@Import({SpringJDBCConfiguration.class})
@SpringBootApplication
public class PracticeDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PracticeDemoApplication.class, args);
		 ApplicationContext context=SpringApplication.run(PracticeDemoApplication.class, args);
			
			// remaining code will write after the break
			
			// perform operation @Employee
			
		EmployeeDAOImpl employeeJDBCTemplate = 
				context.getBean(EmployeeDAOImpl.class);
					
		// method call here 
		runEmployeeCRUD(employeeJDBCTemplate);
		
	}

	 public static void runEmployeeCRUD(EmployeeDAOImpl 
	    		employeeJDBCTemplate) {
				
			// create the employee data 
			
	          employeeJDBCTemplate.setupDB();
			
			System.out.println("------Records Creation--------");
			employeeJDBCTemplate.create("siddu", 11);
			employeeJDBCTemplate.create("bano", 2);
			employeeJDBCTemplate.create("gridhar", 15);

			System.out.println("------Listing Multiple Records--------");
			List<Employee> employees = employeeJDBCTemplate.listEmployees();
			for (Employee record : employees) {
				System.out.print("ID : " + record.getId());
				System.out.print(", Name : " + record.getName());
				System.out.println(", Age : " + record.getAge());
			}
			
	/*
			System.out.println("----Updating Record with ID = 2 -----");
			employeeJDBCTemplate.update(2, 20);
	*/
//			System.out.println("----Listing Record with ID = 2 -----");
//			Employee employee = employeeJDBCTemplate.getEmployee(2);
//			System.out.print("ID : " + employee.getId());
//			System.out.print(", Name : " + employee.getName());
//			System.out.println(", Age : " + employee.getAge());

			
			
		}
}
