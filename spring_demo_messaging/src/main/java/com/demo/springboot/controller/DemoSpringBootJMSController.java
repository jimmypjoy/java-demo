package com.demo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.jms.DemoJMSSender;

@RestController
public class DemoSpringBootJMSController {

	@Autowired
	private DemoJMSSender demoJMSSender;

	@GetMapping("/testSendMessageToActiveMQ")
	public String testSendMessageToActiveMQ(
			@RequestParam(value = "message", defaultValue = "Hello ActiveMQ!") String message) {
		System.out.println("Sending message to ActiveMQ: " + message);
		demoJMSSender.sendMessage(message);
		return "Message sent to ActiveMQ: " + message;
	}
}
