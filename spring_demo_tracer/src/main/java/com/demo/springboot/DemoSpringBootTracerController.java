package com.demo.springboot;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.tracing.Tracer;

@RestController
public class DemoSpringBootTracerController {

	private static final Logger logger = LoggerFactory.getLogger(DemoSpringBootTracerController.class);

	@Autowired
	private Tracer tracer;

	@RequestMapping("/tracerdemo")
	public String hello() {

		Random random = new Random();
		int randomNumber = random.nextInt(100);
		System.out.println("###########################");
		String traceId = tracer.currentSpan().context().traceId();
		System.out.println("traceId:"+traceId);
		logger.info("Handling /tracerdemo request. Current Trace ID: {}", traceId);
		logger.info("Logger statement inside DemoSpringBootTracerController/tracerdemo");
		System.out.println("Inside DemoSpringBootTracerController");
		System.out.println("###########################");
		return "Hello JMJ Spring Boot Tracer: " + randomNumber;
	}

}
