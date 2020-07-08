package com.samples.oop.packageA;

public interface TestInterface2 {
	default public void method1TestInterface2() {
		System.out.println("method1TestInterface2");
	}
	default public void method2TestInterface2() {
		System.out.println("method2TestInterface2");
	}
}
