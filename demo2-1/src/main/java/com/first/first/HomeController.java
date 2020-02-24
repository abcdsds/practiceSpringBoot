package com.first.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/secHello")
	public String hello() {
		return "secHello";
	}
	
	@GetMapping("/my")
	public String my() {
		return "my";
	}
	
	
}

