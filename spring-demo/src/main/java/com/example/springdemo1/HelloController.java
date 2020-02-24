package com.example.springdemo1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfigurationDemo.class);
//		PersonModel personModel = ctx.getBean(PersonModel.class);
//		System.out.println(personModel.getName());

		//
		return "Greetings from Spring Boot and docker jimmy!";
	}

}
