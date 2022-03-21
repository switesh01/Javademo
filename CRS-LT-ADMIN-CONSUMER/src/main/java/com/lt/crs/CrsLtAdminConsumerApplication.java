package com.lt.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
public class CrsLtAdminConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtAdminConsumerApplication.class, args);
	}

}
