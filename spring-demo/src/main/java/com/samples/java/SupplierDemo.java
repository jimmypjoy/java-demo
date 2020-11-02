package com.samples.java;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierDemo {
	public static void main(String[] args) {
		// This function returns a random value.
		Supplier<Double> randomValue = () -> Math.random();
		// Print the random value using get()
		System.out.println(randomValue.get());

		//
		Supplier<String> consoleCapture = () -> {
			String str1 = "Test string for supplier";
			return str1;

		};

		System.out.println(consoleCapture.get());

		// IntSupplier
		IntSupplier intSupplier = () -> {
			int i = 25;
			return i;
		};

		System.out.println(intSupplier.getAsInt());
	}
}
