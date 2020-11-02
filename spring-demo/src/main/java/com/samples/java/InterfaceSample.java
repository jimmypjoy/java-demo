package com.samples.java;

interface Inter1{
	default void method1() {
		System.out.println("Inter1::method1");
	}
	default void method2() {
		System.out.println("Inter1::method2");
	}
	
	private void method3() {
		
	}
	
}

public class InterfaceSample implements Inter1{

}
