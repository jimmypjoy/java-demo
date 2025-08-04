package com.demo.interfaces;

public class DemoInterfaceClass implements DemoInterface {

	public static void main(String[] args) {
		System.out.println("###################");
		DemoInterface.staticMethod();

		DemoInterfaceClass demoInterfaceClass = new DemoInterfaceClass();
		demoInterfaceClass.defaultMethod();
		demoInterfaceClass.abstractMethod();		

		// Calling the default method explicitly
		demoInterfaceClass.invokeDefaultInterfcaeMethodExplicitly();
	}

	@Override
	public void abstractMethod() {
		System.out.println("Inside abstractMethod implementation of DemoInterfaceClass");

	}

	@Override
	public void defaultMethod() {
		System.out.println("Default method in DemoInterfaceClass");

	}

	public void invokeDefaultInterfcaeMethodExplicitly() {
		// Calling the default method explicitly
		DemoInterface.super.defaultMethod();

	}

}
