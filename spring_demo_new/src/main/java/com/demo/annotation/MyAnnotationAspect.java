package com.demo.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAnnotationAspect {

	@Before("@annotation(myAnnotation2)")
	public void beforeMethod(JoinPoint joinPoint, MyAnnotation2 myAnnotation2) {
		System.out.println("Intercepted method: " + joinPoint.getSignature().getName());
		System.out.println("param1: " + myAnnotation2.param1());
		System.out.println("param2: " + myAnnotation2.param2());
	}
}