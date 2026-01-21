package com.demo.springboot;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoSpringBootHelloController {

	@RequestMapping("/hello")
	public String hello() {
		int randomNumber = ThreadLocalRandom.current().nextInt(100);
		return "Hello JMJ Spring Boot: " + randomNumber;
	}

}
