package com.demo.springboot;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class DemoSpringBootServiceImpl {
	public String getGreetingMessage(String name) {
		System.out.println("Invoked DemoSpringBootServiceImpl.getGreetingMessage with name: " + name);
		Random random = new Random();
		int randomNumber = random.nextInt(100);
		return "Hello JMJ from Spring Demo new: " + randomNumber + "	" + name;

	}
}
