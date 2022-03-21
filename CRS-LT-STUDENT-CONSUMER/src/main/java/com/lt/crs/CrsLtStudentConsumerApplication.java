package com.lt.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrsLtStudentConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtStudentConsumerApplication.class, args);
	}

}
