package com.first.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration

//@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {

		//@EnableAutoConfiguration 은 web application으로 만들려고함
		//@Configuration
		//@ComponentScan
		//@EnableAutoConfiguration
		// 이 3가지를 다 사용하는것이 @SpringBootApplication
		//@EnableAutoConfiguration autoconfigure 안에
		// org.springframework.boot.autoconfigure.EnableAutoConfiguration
		// 으로 설정함
		
		SpringApplication application = new SpringApplication(Demo2Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);

		// SpringApplication.run(Demo2Application.class, args);
	}

}
