package com.demo.innerclass;

public class LocalInnerDemo {

	void f1() {
		System.out.println("Inside Outers f1()");
		class LocalInner {
			void f2() {
				System.out.println("Inside LocalInners f2()");
			}
		}
		LocalInner inner = new LocalInner();
		inner.f2();

	}

	public static void main(String[] args) {

		LocalInnerDemo localInnerDemo = new LocalInnerDemo();
		localInnerDemo.f1();

	}

}
