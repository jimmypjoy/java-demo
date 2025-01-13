package com.demo.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springboot.eurekaclient.Cloud1Client;

@RestController
public class EurekaClientController {

	private final Cloud1Client cloud1Client;

	public EurekaClientController(Cloud1Client cloud1Client) {
		this.cloud1Client = cloud1Client;
	}

	@GetMapping("/call-cloud1")
	public String callCloud1() {
		System.out.println("Inside EurekaClientController####################");
		return cloud1Client.getHello();
	}
}
