package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringDemoEurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoEurekaApplication.class, args);
	}
}