package com.samples.spring.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.samples.spring.application.SpringDemoApplication;

@RunWith(SpringRunner.class)
@WebMvcTest(JunitController.class)
public class HelloWorldControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void helloWorld_basic() throws Exception {
		//call GET "/hello-world"  application/json
		
		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello-junit")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World from spring junit"))
				.andReturn();
	
		//verify "Hello World"
		//assertEquals("Hello World", result.getResponse().getContentAsString());
	}

}
