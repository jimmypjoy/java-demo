package com.samples.java;

public class InstanceOfSample {
	public static void main(String[] args) {
		if (method1() instanceof String str) {
			System.out.println(str.toUpperCase());
		}

	}

	private static Object method1() {
		return "test";
	}
}
