package com.samples;

import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalDemo {
	public static void main(String[] args) {
		OptionalDouble optionalEmpty = OptionalDouble.empty();
		System.out.println(optionalEmpty.isPresent());

		OptionalDouble optionalDouble = OptionalDouble.of(100);
		System.out.println(optionalDouble.isPresent());
		System.out.println(optionalDouble.getAsDouble());
		//
		Optional<String> empty = Optional.empty();
		System.out.println(empty.isPresent());
		System.out.println(empty);
		//
		Optional<String> optional1 = Optional.of("Test 1");
		System.out.println(optional1.isPresent());
		System.out.println(optional1.get());
		System.out.println(optional1);
		//
		Integer year = 2016;
		Optional<Integer> yearOptional = Optional.of(year);
		System.out.println(yearOptional.filter(y -> y == 2016).isPresent());
	}
}
