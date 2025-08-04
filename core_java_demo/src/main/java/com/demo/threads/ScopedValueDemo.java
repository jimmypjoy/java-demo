package com.demo.threads;

public class ScopedValueDemo {
	// Define a static ScopedValue
	static final ScopedValue<String> USER = ScopedValue.newInstance();

	public static void main(String[] args) {
		ScopedValue.where(USER, "JJ").run(() -> {
			System.out.println("Hello, " + USER.get()); // Prints: Hello, JJ
			someOtherMethod();
		});

		System.out.println("#########");
		// Outside the scope: USER is not bound
//		 System.out.println(USER.get()); // This would throw IllegalStateException
	}

	static void someOtherMethod() {
		System.out.println("From other method: " + USER.get()); // Still accessible
	}
}
