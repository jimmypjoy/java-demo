package com.samples.oop;

public interface Interface1 {

	default void defaultMethod1() {
		System.out.println("inisde default void Interface1::defaultMethod1()");
	}

	void abstarctMthod1();

	static void staticMethod1() {
		System.out.println("Inside static void Interface1::staticMethod1()");
	}

}
