package com.demo.springboot;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoSpringBootHelloController {

	private static final Logger logger = LoggerFactory.getLogger(DemoSpringBootHelloController.class);

	@RequestMapping("/hello")
	public String hello() {

		Random random = new Random();
		int randomNumber = random.nextInt(100);
		System.out.println("###########################");
		logger.info("Logger statement inside DemoSpringBootHelloController/hello");
		System.out.println("Inside DemoSpringBootHelloController of Cloud1");
		System.out.println("###########################");
		return "Hello JMJ Spring Boot Cloud 1: " + randomNumber;
	}

}
