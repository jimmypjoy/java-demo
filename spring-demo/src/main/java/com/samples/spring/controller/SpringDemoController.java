package com.samples.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.spring.application.SpringDemoApplicationConfiguration;
import com.samples.spring.demo.ApplicationPropertyConfiguration;

@RestController
@PropertySource("classpath:application.properties")
public class SpringDemoController {

	@Autowired
	private ApplicationPropertyConfiguration applicationPropertyConfiguration;

	private static Logger LOGGER = LoggerFactory.getLogger(SpringDemoController.class);

//	@Autowired
//	private ApplicationContext applicationContext;

//	@Autowired
//	private PersonModel personModel;

	@RequestMapping("/greetings")
	public String index() {
		System.out.println("inside test program");
		// getting ApplicationContext
//		System.out.println(personModel.getName());
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfigurationDemo.class);
//		PersonModel personModel = ctx.getBean(PersonModel.class);
//		System.out.println(personModel.getName());
		System.out.println(applicationPropertyConfiguration.getTestProperty());

		//
		String meesage = "Greetings from Spring Boot and docker jimmy!";
		LOGGER.info("Logging from SpringDemoController: " + meesage);
		return meesage;
	}

}
