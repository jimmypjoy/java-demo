package com.samples;

public class VarArgsDemo {
	public static void main(String[] args) {

		VarArgsDemo varArgsDemo = new VarArgsDemo();
		System.out.println("varArgsDemo.method1(\"Str1\");");
		varArgsDemo.method1("Str1");

		System.out.println("varArgsDemo.method1(\"Str1\",\"Str21\",\"Str22\");");
		varArgsDemo.method1("Str1", "Str21", "Str22");
	}

	private void method1(String str1, String... strs2) {
		System.out.println(str1);
		for (String str2 : strs2) {
			System.out.println(str2);
		}
	}
}
