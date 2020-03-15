package com.samples.spring.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.samples.spring.model.PersonModel;

@SpringBootApplication(scanBasePackages = { "com.*" })
@EnableJpaRepositories(basePackages = { "com.samples.spring.data" })
@EntityScan(basePackages = { "com.samples.spring.model" })
public class SpringDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
		PersonModel personModel = context.getBean(PersonModel.class);
		System.out.println(personModel.getName());
		PersonModel personModel1 = context.getBean(PersonModel.class);
		System.out.println(personModel1.getName());
	}
}
