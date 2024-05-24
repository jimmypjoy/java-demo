package com.demo.annotation;

import org.springframework.stereotype.Component;

@Component
public class AnnotationTest {

	@MyAnnotation2(param1 = "Hello", param2 = "World")
	public void myMethod2() {
		System.out.println("Inside AnnotationTest.myMethod2() ");
	}
}