package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringDemoGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoGatewayApplication.class, args);
	}
}
