package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ComponentScan({"com.lt.*"})
@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
public class DemoLtSpringRestPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoLtSpringRestPracticeApplication.class, args);
	}

}
