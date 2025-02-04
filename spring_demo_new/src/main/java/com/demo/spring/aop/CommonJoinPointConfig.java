package com.demo.spring.aop;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.demo.spring.data.*.*(..))")
	public void dataLayerExecution() {
	}

	@Pointcut("execution(* com.demo.spring.business.*.*(..))")
	public void businessLayerExecution() {
	}

	@Pointcut("dataLayerExecution() && businessLayerExecution()")
	public void allLayerExecution() {
	}

	@Pointcut("bean(*dao*)")
	public void beanContainingDao() {
	}

	@Pointcut("within(com.demo.spring.data..*)")
	public void dataLayerExecutionWithWithin() {
	}

	@Pointcut("@annotation(com.demo.spring.aop.TrackTime)")
	public void trackTimeAnnotation() {
	}
}
