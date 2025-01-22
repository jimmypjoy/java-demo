package com.demo.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

	@Before("execution(* com.demo.springboot.DemoSpringBootHelloController.*(..))")
	public void before(JoinPoint joinPoint) {
		System.out.println("######################################");
		System.out.println("Inside DemoAspect before: ");

		// Get method name
		String methodName = joinPoint.getSignature().getName();
		System.out.println("Method: " + methodName);

		// Get class name
		String className = joinPoint.getTarget().getClass().getSimpleName();
		System.out.println("Class: " + className);

		// Get method arguments
		Object[] args = joinPoint.getArgs();
		if (args.length > 0) {
			System.out.print("Arguments: ");
			for (Object arg : args) {
				System.out.print(arg + " ");
			}
			System.out.println();
		} else {
			System.out.println("No arguments passed.");
		}

		// Get method signature (detailed info)
		System.out.println("Method signature: " + joinPoint.getSignature().toString());

		System.out.println("######################################");
	}
}
