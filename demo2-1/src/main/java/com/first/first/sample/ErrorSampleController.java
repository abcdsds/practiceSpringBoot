package com.first.first.sample;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorSampleController {

	@GetMapping("/exception")
	public String hello() {
		throw new SampleException();
	}
	
	@ExceptionHandler(SampleException.class)
	public @ResponseBody AppError SampleError(SampleException e) {
		
		
		AppError appError = new AppError();
		appError.setMessage("error.app.Key "+e.getMessage());
		appError.setReason("IDK IDK");
		
		
		return appError;
	}
	
	
	
}
