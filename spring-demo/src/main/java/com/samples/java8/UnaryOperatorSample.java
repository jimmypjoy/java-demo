package com.samples.java8;

import java.util.function.UnaryOperator;

public class UnaryOperatorSample {
	public static void main(String[] args) {
		UnaryOperator<Double> sqrt = (d) -> Math.sqrt(d);
		System.out.println(sqrt.apply(36.0));
	}
}
