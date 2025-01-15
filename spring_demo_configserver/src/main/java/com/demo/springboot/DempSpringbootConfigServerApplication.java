package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DempSpringbootConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DempSpringbootConfigServerApplication.class, args);
	}

}