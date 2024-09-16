package com.demo.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//AOP
//Configuration
@Aspect
@Configuration
public class DemoBeforeAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// What kind of method calls I would intercept
	// execution(* PACKAGE.*.*(..))
	// Weaving & Weaver
	@Before("com.demo.spring.aop.CommonJoinPointConfig.businessLayerExecution()")
	public void before(JoinPoint joinPoint) {
		// Advice
		logger.info(" #####DemoBeforeAspect ");
		logger.info(" ####inside execution for {}", joinPoint);
	}
}