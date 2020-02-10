package com.first.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
//@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {

		SpringApplication application = new SpringApplication(Demo2Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
		
		// SpringApplication.run(Demo2Application.class, args);
	}

}
