package com.samples.spring.application;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.samples.spring.model.PersonModel;

@Configuration
@ComponentScan("com")
public class SpringDemoApplicationConfiguration {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringDemoApplicationConfiguration.class);

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringDemoApplicationConfiguration.class)) {

			PersonModel personModel = applicationContext.getBean(PersonModel.class);
			System.out.println(personModel.getName());
			PersonModel personModel1 = applicationContext.getBean(PersonModel.class);
			System.out.println(personModel1.getName());
			System.out.println("Printing all bean names loaded:");
			Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(System.out::print);
			LOGGER.info("{}", personModel);
		}
	}
}
