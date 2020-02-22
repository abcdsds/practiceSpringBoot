package com.first.first;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class BaseConfiguration {

	@Bean
	public String Hello() {
		return "hello";
	}
}
