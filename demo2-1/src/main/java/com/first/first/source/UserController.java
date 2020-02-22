package com.first.first.source;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/helloUser")
	public String hello() {
		return "hello";
	}
	
	
	@PostMapping("/users/create")
	//@RestController 애노테이션이 클래스위에 붙어있으면 메소드에 @ResponseBody 생략가능
	public User create(@RequestBody User user){
		return user;
	}
}
