package com.first.first.sample;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(HateOasSampleController.class)
class HateOasSampleControllerTest {

	@Autowired
	MockMvc mockkMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void test() throws Exception {
		
		
		
		mockkMvc.perform(get("/hello_HateOas"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$._links.self").exists());
		
	}

}
