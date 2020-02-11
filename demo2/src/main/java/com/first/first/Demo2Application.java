package com.first.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@Configuration
//@ComponentScan
//@EnableAutoConfiguration

@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {

		//@EnableAutoConfiguration 은 web application으로 만들려고함
		//@Configuration
		//@ComponentScan
		//@EnableAutoConfiguration
		// 이 3가지를 다 사용하는것이 @SpringBootApplication
		//@EnableAutoConfiguration autoconfigure 안에
		// org.springframework.boot.autoconfigure.EnableAutoConfiguration
		// 으로 키값을 설정함
		// 다 적용시키는건아니고 @conditional로 적용여부를 체크함
		
		SpringApplication application = new SpringApplication(Demo2Application.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);

		// SpringApplication.run(Demo2Application.class, args);
	}
	
	
	// 2.1버전 이후에는 에러남
	// The bean 'holoman', defined in com.first.first.Demo21Application, could not be registered. A bean with that name has already been defined in class path resource [com/first/first/HolomanConfiguration.class] and overriding is disabled.
	// Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true
	//
	
	@Bean
	public Holoman holeman() {
		Holoman holoman= new Holoman();
		holoman.setHowLong(60);
		holoman.setName("ds");
		return holoman;
	}

}
