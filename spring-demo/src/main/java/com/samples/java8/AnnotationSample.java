package com.samples.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationSample {

	@TestAnnotation
	public void testMethod() {
		System.out.println("test...");
	}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestAnnotation {

}
