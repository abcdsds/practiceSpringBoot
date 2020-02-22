package com.first.first.sample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@RunWith(SpringRunner.class)
@WebMvcTest(ThymeleafSampleController.class)
class ThymeleafSampleControllerTest {

	// 요청 /hello/thymeleaf
	// 응답 
	// - 모델 name : ds
	// - 뷰 이름 : hello
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	void hello() throws Exception {
		mockMvc.perform(get("/hello/thymeleaf"))
		.andExpect(status().isOk())
		.andDo(print())
		.andExpect(view().name("hello"))
		.andExpect(model().attribute("name", is("ds")))
		.andExpect(content().string(containsString("ds")));
	}
	
	@Autowired
	WebClient webClient;
	
	@Test
	void webHello() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		HtmlPage page = webClient.getPage("/hello/thymeleaf");
		HtmlHeading1 h1 = page.getFirstByXPath("//h1");
		assertThat(h1.getTextContent()).isEqualToIgnoringCase("ds");
		
	}

}
