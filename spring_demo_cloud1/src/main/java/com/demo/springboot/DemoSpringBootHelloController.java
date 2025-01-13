package com.demo.springboot;

import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoSpringBootHelloController {

	@RequestMapping("/hello")
	public String hello() {
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		System.out.println("###########################");
		System.out.println("Inside DemoSpringBootHelloController of Cloud1");
		System.out.println("###########################");
		return "Hello JMJ Spring Boot Cloud 1: " + randomNumber;
	}

}
