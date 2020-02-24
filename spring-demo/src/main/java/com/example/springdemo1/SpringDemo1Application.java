package com.example.springdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.*"})
//@EnableJpaRepositories(basePackages = {"com.samples.junit.spring.data"})
//@EntityScan(basePackages =  {"com.samples.junit.spring.model"})
public class SpringDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo1Application.class, args);
	}
}
