package com.demo.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.demo.springboot.restclient.EmployeeRestTemplate;

@SpringBootApplication
public class DemoSpringbootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringbootApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoSpringbootApplication.class);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	// Beans CommandLineRunner interface are executed after the Spring application
	// context is fully initialized and the application is ready to run.
	@Bean
	public CommandLineRunner run(ApplicationContext context) {
		return args -> {
			EmployeeRestTemplate employeeRestTemplate = context.getBean(EmployeeRestTemplate.class);
			employeeRestTemplate.fetchEmployee();
		};
	}
}
