package com.system.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HealthApiApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(HealthApiApplication.class, args);
	}

}
