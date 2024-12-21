package com.demo.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.jms.DemoJMSSender;

@RestController
public class DemoSpringBootHelloController {

	@Autowired
	private DemoSpringBootServiceImpl demoSpringBootService;

	@Autowired
	private DemoJMSSender demoJMSSender;

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("Inside DemoSpringBootHelloController");
		String message = demoSpringBootService.getGreetingMessage(name);
		return message;
	}

	@GetMapping("/testSendMessageToActiveMQ")
	public String testSendMessageToActiveMQ(
			@RequestParam(value = "message", defaultValue = "Hello ActiveMQ!") String message) {
		System.out.println("Sending message to ActiveMQ: " + message);
		demoJMSSender.sendMessage(message);
		return "Message sent to ActiveMQ: " + message;
	}
}
