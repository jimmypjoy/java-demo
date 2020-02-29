package com.samples.java8.model;

public class TestGeneric<S, T extends Number> {

	private S name;
	private T age;

	public TestGeneric(S name, T age) {
		this.name = name;
		this.age = age;
	}

	public S getName() {
		return name;
	}

	public void setName(S name) {
		this.name = name;
	}

	public T getAge() {
		return age;
	}

	public void setAge(T age) {
		this.age = age;
	}
}
