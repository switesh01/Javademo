package com.lt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.lt.configuration.ConfigurationJDBC;

@ComponentScan({"com.lt.*"})
@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@SpringBootApplication
@Import(ConfigurationJDBC.class)
public class CrsLtGrp4SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtGrp4SpringRestApplication.class, args);
	}

}
