package com.lt.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CrsLtUserConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtUserConsumerApplication.class, args);
	}

}
