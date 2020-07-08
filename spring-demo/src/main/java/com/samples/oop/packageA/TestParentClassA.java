package com.samples.oop.packageA;

public class TestParentClassA {
	public TestParentClassA() {
		System.out.println("TestParentClassA: constructor");
	}

	static {
		System.out.println("TestParentClassA: static init");
	}

	{
		System.out.println("TestParentClassA: instance init");
	}
}
