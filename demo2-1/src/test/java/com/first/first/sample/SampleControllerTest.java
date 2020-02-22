package com.first.first.sample;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SampleControllerTest {

	@Rule
	public OutputCapture outputcapture = new OutputCapture();
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Autowired
	WebTestClient webTestClient;
	
	@MockBean
	SampleService mockSampleService;
		
	@Test
	public void hello() throws Exception {
	
		assertThat(outputcapture.toString())
		.contains("ds")
		.contains("kds");
		
		when(mockSampleService.getName()).thenReturn("jdsjds");
				
		//String result = testRestTemplate.getForObject("/helloSample", String.class);
		//assertThat(result).isEqualTo("hello!dsds");
		
		webTestClient.get().uri("/helloSample").exchange()
							.expectStatus().isOk()
							.expectBody(String.class).isEqualTo("hello!dsds");
		
		
	}
	
}
