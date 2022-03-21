package com.lt.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//Eureka server for all the 4 microservices/eureka clients
@SpringBootApplication
@EnableEurekaServer //Declares this Spring Boot App as the eureka server
public class CrsLtEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtEurekaServerApplication.class, args);
	}

}
