package com.samples.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JunitController {

	@GetMapping("/hello-junit")
	public String helloWorld() {
		return "Hello World from spring junit";
	}
	
}
