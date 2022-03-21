package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.example.application.DemoCoreSpringProjectApplication;
import com.example.configuration.AppConfig;
import com.example.service.HelloWorld;

@SpringBootApplication
@ComponentScan({"com.example"})
@Import({AppConfig.class})
@EnableAutoConfiguration
public class DemoCoreSpringProjectApplication {

	public static void main(String[] args) {

		// spring 3 syntax
		// ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Spring 4 Syntax
		ApplicationContext context = SpringApplication.run(AppConfig.class);
		HelloWorld obj = (HelloWorld) context.getBean("helloBean");

		obj.printHelloWorld("Spring 5 Java Config");
	}
}
