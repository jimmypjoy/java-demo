package com.demo.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	@Value("${testconfigserver.testproperty:Default Value}")
	private String testProperty;

	@GetMapping("/democonfigproperty")
	public String printProperty() {
		System.out.println("#########################################");
		System.out.println("Inside ConfigClientController: testProperty -" + testProperty);
		return "Property value from Config Server: " + testProperty;
	}
}
