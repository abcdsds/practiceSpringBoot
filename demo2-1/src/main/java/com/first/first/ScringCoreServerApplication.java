package com.first.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@SpringBootApplication
@RestController
public class ScringCoreServerApplication {

	@CrossOrigin(origins= "http://localhost:18080")
	@GetMapping("/helloCore")
	public String hello() {
		return "Hello";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ScringCoreServerApplication.class, args);
	}
}
