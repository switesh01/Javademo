package com.lt.crs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories
//@ComponentScan(basePackages = {"com.lt.crs.*"})
public class CrsLtSpringRestJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrsLtSpringRestJpaApplication.class, args);
	}

}
