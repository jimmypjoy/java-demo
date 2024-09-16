package com.demo.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Around("com.demo.spring.aop.CommonJoinPointConfig.businessLayerExecution()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object returnProceed = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("####### Time Taken by {} is {}", joinPoint, timeTaken);

		return returnProceed;
	}

	@Around("com.demo.spring.aop.CommonJoinPointConfig.trackTimeAnnotation()")
	public Object aroundWithAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();

		Object returnProceed = joinPoint.proceed();

		long timeTaken = System.currentTimeMillis() - startTime;
		logger.info("#######With annotation Time Taken by {} is {}", joinPoint, timeTaken);

		return returnProceed;
	}
}
