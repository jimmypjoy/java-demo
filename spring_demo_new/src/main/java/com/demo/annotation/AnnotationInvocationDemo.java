package com.demo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.AppConfig;

public class AnnotationInvocationDemo {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AnnotationTest test = context.getBean(AnnotationTest.class);
		test.myMethod2();
		System.out.println("AnnotationInvocationDemo main completed");
	}
}
