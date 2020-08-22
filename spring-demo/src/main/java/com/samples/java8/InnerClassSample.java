package com.samples.java8;

public class InnerClassSample {
	private String outerStr1 = "outerStr1";

	class InnerClass {
		private void innerMethod1() {
			System.out.println(outerStr1);
		}

	}

	public static void main(String[] args) {
		InnerClassSample innerClassSample = new InnerClassSample();
		InnerClass innerClass = innerClassSample.new InnerClass();
		innerClass.innerMethod1();
		innerClassSample.outerMethod1();
	}

	private void outerMethod1() {
		System.out.println("inside outerMethod1");
		InnerClass innerClass1 = new InnerClass();
		innerClass1.innerMethod1();

		// method local inner class
		class MethodLocalInnerClass {
			private void methodLocalInnerMethod1() {
				System.out.println("inside methodLocalInnerMethod1");
				outerStr1 = "outerStr1Modified";
				System.out.println("outerStr1 from methodLocalInnerMethod1:" + outerStr1);
			}
		}
		MethodLocalInnerClass methodLocalInnerClass = new MethodLocalInnerClass();
		methodLocalInnerClass.methodLocalInnerMethod1();

	}

}
