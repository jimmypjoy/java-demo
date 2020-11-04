package com.samples.java;

public class RecodSample {
	public static void main(String[] args) {

		Record1 rec = new Record1("test", 10);
		System.out.println(rec.name());
		System.out.println(rec.age());
		System.out.println(rec);
	}

}

record Record1(String name, int age) {

}
