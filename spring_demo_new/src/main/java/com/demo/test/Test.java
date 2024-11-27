package com.demo.test;

public class Test {

	String first;
	String last;
	String full = first + last;

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.full);
	}
}
