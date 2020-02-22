package com.first.first.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafSampleController {

	@GetMapping("/hello/thymeleaf")
	public String hello(Model model) {
		model.addAttribute("name", "ds");
		return "hello";
	}
}
