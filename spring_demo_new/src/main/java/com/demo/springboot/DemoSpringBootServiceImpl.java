package com.demo.springboot;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class DemoSpringBootServiceImpl {
	public String getGreetingMessage(String name) {
		System.out.println("Invoked DemoSpringBootServiceImpl.getGreetingMessage with name: " + name);
		int randomNumber = ThreadLocalRandom.current().nextInt(100);
		return "Hello JMJ from Spring Demo new: " + randomNumber + "	" + name;

	}
}
