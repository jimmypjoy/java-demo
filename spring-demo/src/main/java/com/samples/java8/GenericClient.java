package com.samples.java8;

import com.samples.java8.model.TestGeneric;

public class GenericClient {
	public static void main(String[] args) {
		TestGeneric<String, Float> testGeneric = new TestGeneric<String, Float>("JJ", 13.0f);
		testMethod(testGeneric);

		// Below code will cause runtime error as the wrong type is set for name in a
		// method
		System.out.println(testGeneric.getName());
		System.out.println(testGeneric.getAge());

	}

	private static void testMethod(Object object) {
		TestGeneric testGenericLocal = (TestGeneric) object;
		// set wrong type in a method. Code will compile. will cause run time error when
		// name is accessed
		testGenericLocal.setName(new Integer(1));
		System.out.println(testGenericLocal.getName());
		System.out.println(testGenericLocal.getAge());

	}
}
