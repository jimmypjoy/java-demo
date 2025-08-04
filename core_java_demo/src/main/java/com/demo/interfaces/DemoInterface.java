package com.demo.interfaces;

public interface DemoInterface {
	int CONSTANT_VALUE = 100; // public, static, final by default

	void abstractMethod(); // Abstract method (implicitly public and abstract)

	default void defaultMethod() {
		System.out.println("Default method in an interface");
		privateHelperMethod();
		// static methods can be called by other methods in an interface
		privateStaticHelper();
	}

	private void privateHelperMethod() {
		System.out.println("Private method in an interface");
	}

	static void staticMethod() {
		System.out.println("Static method in an interface");
		privateStaticHelper();
	}

	private static void privateStaticHelper() {
		System.out.println("Private static method in an interface");
	}
}
