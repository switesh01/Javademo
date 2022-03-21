package com.crs.lt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan("com.crs.lt.*")
@SpringBootApplication
public class CustomerProducerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProducerApiApplication.class, args);
	}

}
