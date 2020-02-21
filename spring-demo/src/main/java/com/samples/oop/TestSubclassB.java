package com.samples.oop;

import com.samples.oop.packageA.TestInterface1;
import com.samples.oop.packageA.TestInterface2;
import com.samples.oop.packageA.TestParentClassA;

public class TestSubclassB extends TestParentClassA implements TestInterface1, TestInterface2 {
	
	public TestSubclassB() {
		System.out.println("TestSubclassB: constructor");
	}
	
	static {
		System.out.println("TestSubclassB: static init");
	}
	
	{
		System.out.println("TestSubclassB: instance init");
	}
	
	public static void main(String[] args) {
		TestSubclassB testSubclassB = new TestSubclassB();
		testSubclassB.test();
		System.out.println("finished");
	}

	private void test() {

		this.method1TestInterface1();
		this.method2TestInterface1();
		
		this.method1TestInterface2();
		this.method2TestInterface2();
		//call interface super method
		TestInterface1.super.method1TestInterface1();

	}

	@Override
	public void method2TestInterface1() {
		System.out.println("implementation in class for method2TestInterface1");
		
	}
}
