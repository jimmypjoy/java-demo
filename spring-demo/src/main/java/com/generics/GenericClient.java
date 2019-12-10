package com.generics;

public class GenericClient {
	public static void main(String[] args) {
		TestGeneric<String, Float> testGeneric = new TestGeneric<String, Float>("JJ", 13.0f);
		System.out.println(testGeneric.getName());
		System.out.println(testGeneric.getAge());
	}
}
