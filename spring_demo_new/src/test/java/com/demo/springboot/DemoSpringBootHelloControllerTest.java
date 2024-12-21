package com.demo.springboot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(DemoSpringBootHelloController.class)
public class DemoSpringBootHelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DemoSpringBootServiceImpl demoSpringBootService;

    @Test
    public void testHelloEndpointWithName() throws Exception {
        // Arrange
        String name = "John";
        String expectedMessage = "Hello, John!";
        
        when(demoSpringBootService.getGreetingMessage(name)).thenReturn(expectedMessage);

        // Act & Assert
        mockMvc.perform(get("/hello").param("name", name))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMessage));
    }

    @Test
    public void testHelloEndpointWithDefaultName() throws Exception {
        // Arrange
        String defaultName = "World";
        String expectedMessage = "Hello, World!";
        
        when(demoSpringBootService.getGreetingMessage(defaultName)).thenReturn(expectedMessage);

        // Act & Assert
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedMessage));
    }
}
