package com.samples.java;

interface Inter1 {
	default void method1() {
		System.out.println("Inter1::method1");
		method3();
	}

	default void method2() {
		System.out.println("Inter1::method2");
	}

	private void method3() {
		System.out.println("Inter1 Private method ::method3");
	}

	private static void method5() {
		System.out.println("Inter1::static private method5");
	}

	static void method4() {
		System.out.println("Inter1::static method4");
		method5();
	}

}

public class InterfaceSample implements Inter1 {
	public static void main(String[] args) {
		InterfaceSample interfaceSample = new InterfaceSample();
		interfaceSample.method1();
		Inter1.method4();
	}

}
