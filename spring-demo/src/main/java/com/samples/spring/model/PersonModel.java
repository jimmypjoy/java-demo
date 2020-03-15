package com.samples.spring.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PersonModel {
	private String name = "test bean name jj:" + Math.random();
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("inside post construct:" + this.getName());

	}

	@PreDestroy
	public void preDestroy() {
		System.out.println("inside pre destroy:" + this.getName());

	}
}
