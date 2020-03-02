package com.first.first;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorController {

	@GetMapping("/helloAct")
	public String hello() {
		return "hello";
	}
}
