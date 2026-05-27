package com.demo.test;

import java.util.List;

public class Test {
	public static void main(String[] args) throws Exception {

		var numStream = List.of(0, 1, 22, 3, -13, 4, -5, 6, 7, 7, 8, 11);
		var num = numStream.stream().distinct().filter(i -> i % 3 == 1).sorted().findFirst().get();
		System.out.println(num);
	}

}