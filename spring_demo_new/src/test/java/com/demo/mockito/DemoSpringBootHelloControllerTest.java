package com.demo.mockito;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.springboot.DemoSpringBootHelloController;
import com.demo.springboot.DemoSpringBootServiceImpl;

@WebMvcTest(DemoSpringBootHelloController.class)
public class DemoSpringBootHelloControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private DemoSpringBootServiceImpl demoSpringBootService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetGreetingMessage() throws Exception {
		// Arrange
		String name = "John";
		when(demoSpringBootService.getGreetingMessage(name)).thenReturn("Hello JMJ from Spring Demo new:" + name);

		// Act & Assert
		mockMvc.perform(get("/greet").param("name", name)).andExpect(status().isOk())
				.andExpect(content().string("Hello, John!"));
	}
}