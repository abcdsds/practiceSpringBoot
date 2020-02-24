package com.first.first;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
@WithMockUser
class HomeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	@WithMockUser
	void test() throws Exception {
		mockMvc.perform(get("/secHello").accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(status().isOk())
		.andExpect(view().name("secHello"));
	}
	
	@Test
	@WithMockUser
	void my() throws Exception {
		mockMvc.perform(get("/my"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(view().name("my"));
	}

}