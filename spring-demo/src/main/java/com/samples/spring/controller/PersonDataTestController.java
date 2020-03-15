package com.samples.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samples.spring.business.PersonSpringJdbcService;
import com.samples.spring.business.PersonSpringJpaService;

@RestController
public class PersonDataTestController {

	@Autowired
	private PersonSpringJdbcService personSpringJdbcService;

	@Autowired
	private PersonSpringJpaService personSpringJpaService;

	@GetMapping("/spring-jdbc-test")
	public String springJdbcTest() throws Exception {
		personSpringJdbcService.invokeSpringJdbcServices();
		return "Spring JDBC test completed";
	}

	@GetMapping("/spring-jpa-test")
	public String springJpsTest() throws Exception {
		personSpringJpaService.invokeSpringJdbcServices();
		return "Spring JPA test completed";
	}

}
