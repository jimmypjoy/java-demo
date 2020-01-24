package com.example.springdemo1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.configuration.SpringConfigurationDemo;
import com.spring.samples.model.PersonModel;

@RestController
public class HelloController {

//	@Autowired
//	private ApplicationContext applicationContext;

//	@Autowired
//	private PersonModel personModel;

	@RequestMapping("/greetings")
	public String index() {
		System.out.println("inside test program");
		// getting ApplicationContext
//		System.out.println(personModel.getName());
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfigurationDemo.class);
//		PersonModel personModel = ctx.getBean(PersonModel.class);
//		System.out.println(personModel.getName());

		//
		return "Greetings from Spring Boot and docker jimmy!";
	}

}
