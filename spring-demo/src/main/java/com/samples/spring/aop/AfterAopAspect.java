package com.samples.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class AfterAopAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@AfterReturning(value = "com.samples.spring.aop.CommonJoinPointConfig.businessLayerExecution()", returning = "result")
	public void afterReturning(JoinPoint joinPoint, Object result) {
		logger.info("{} returned with value {}", joinPoint, result);
	}

	@After("com.samples.spring.aop.CommonJoinPointConfig.businessLayerExecution()")
	public void after(JoinPoint joinPoint) {
		logger.info("@@@@@ after execution of {}", joinPoint);
	}

	@Before("execution(* com.samples.spring.business.*.*(..))")
	public void before() {
		System.out.println("#####inside aspect interceptor#######");

	}
}
