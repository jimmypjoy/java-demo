package com.samples.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.spring.demo.ApplicationPropertyConfiguration;

@RestController
@PropertySource("classpath:application.properties")
public class SpringDemoController {

	@Autowired
	private ApplicationPropertyConfiguration applicationPropertyConfiguration;

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
		return "Greetings from Spring Boot and docker jimmy!";
	}

}
