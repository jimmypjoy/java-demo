package com.demo.drools;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private int age;

	private List<String> messages = new ArrayList<>();

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void addMessage(String message) {
        this.messages.add(message);
    }
}
