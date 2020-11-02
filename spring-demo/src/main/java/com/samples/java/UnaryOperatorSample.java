package com.samples.java;

import java.util.function.UnaryOperator;

public class UnaryOperatorSample {
	public static void main(String[] args) {
		UnaryOperator<Double> sqrt = (d) -> Math.sqrt(d);
		System.out.println(sqrt.apply(36.0));
	}
}
