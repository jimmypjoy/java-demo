package com.samples.java;

public class VarSample {
	public static void main(String[] args) {
		var testClass = new TestClass();
		testClass.method1();
		var i = 10;
		System.out.println(i);
		var s = "str";
		System.out.println(s);
	}

}

class TestClass {
	public void method1() {
		System.out.println("method1");
	}
}
