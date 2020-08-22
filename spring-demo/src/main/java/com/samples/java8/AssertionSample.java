package com.samples.java8;

public class AssertionSample {
	public static void main(String[] args) {
		AssertionSample assertionSample = new AssertionSample();
		assertionSample.method1(11);

	}

	private void method1(int number) {
//		assert (number < 10);
		assert (number < 10):"number should be greater than 10";
		if (number < 10) {
			System.out.println("Number is:" + number);
		}

	}
}
