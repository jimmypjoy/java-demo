package com.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoSpringBootHelloController {

	@Autowired
	private DemoSpringBootServiceImpl demoSpringBootService;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("Inside DemoSpringBootHelloController");
		String message = demoSpringBootService.getGreetingMessage(name);
		return message;
	}

}
