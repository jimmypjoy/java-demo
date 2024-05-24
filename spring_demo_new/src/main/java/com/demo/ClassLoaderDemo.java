package com.demo;

import java.lang.reflect.Method;

public class ClassLoaderDemo {

	public static void main(String[] args) throws Exception {
		Class c = Class.forName("com.demo.ClassLoaderDemo");
		System.out.println(c.getClassLoader());

		System.out.println(String.class.getClassLoader());

		Method[] methods = c.getDeclaredMethods();

		for (Method method : methods) {
			System.out.println(method.getName());
		}
		System.out.println(methods.length);

		ClassLoaderDemo classLoaderDemo = new ClassLoaderDemo();
		classLoaderDemo.testMethod();

	}

	private void testMethod() {
		System.out.println(this.getClass().getClassLoader());
	}
}
