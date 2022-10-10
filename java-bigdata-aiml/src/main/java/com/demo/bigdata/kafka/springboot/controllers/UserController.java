package com.demo.bigdata.kafka.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.bigdata.kafka.springboot.producer.dto.User;
import com.demo.bigdata.kafka.springboot.producer.service.UserProducerService;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	private UserProducerService service;

	@GetMapping("/publishUserData/{name}/{age}/{genre}")
	public void sendUserData(@PathVariable("name") String name, @PathVariable("age") int age,
			@PathVariable("genre") String genre) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setFavGenre(genre);
		System.out.println("Inside UserController- name:" + name);
		service.sendUserData(user);
	}
}
