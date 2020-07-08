package com.samples.oop;

public class Class1 implements Interface1 {

	protected String str1ClassSample1;

	@Override
	public void abstarctMthod1() {
		System.out.println(" void abstarctMthod1()::Class1");
	}

	public static void main(String[] args) {
		Interface1.staticMethod1();
		Class1 classSample1 = new Class1();
		classSample1.abstarctMthod1();
		classSample1.defaultMethod1();
	}
}
