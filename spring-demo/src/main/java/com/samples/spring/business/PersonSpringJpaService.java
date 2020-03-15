package com.samples.spring.business;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import com.samples.spring.data.PersonSpringDataRepository;
import com.samples.spring.model.Person;

@Service
public class PersonSpringJpaService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonSpringDataRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(PersonSpringJpaService.class, args);
	}

	public void invokeSpringJdbcServices() throws Exception {
		
//		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		logger.info("Inserting -> {}", 
				repository.save(new Person("jj", "jpa1", new Date())));
		
//		logger.info("Update 10003 -> {}", 
//				repository.save(new Person(10003, "Pieter", "Utrecht", new Date())));
		
//		repository.deleteById(10002);

		logger.info("All users -> {}", repository.findAll());
	}
}
