package com.samples.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFlatMapDemo {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");

// Using Stream flatMap(Function mapper) 
		list.stream().flatMap(str -> Stream.of(str.charAt(2))).forEach(System.out::println);
	}
}
