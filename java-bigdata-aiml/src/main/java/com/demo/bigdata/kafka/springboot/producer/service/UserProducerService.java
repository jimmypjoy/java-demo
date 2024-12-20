package com.demo.bigdata.kafka.springboot.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.demo.bigdata.kafka.springboot.producer.dto.User;

@Service
public class UserProducerService {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendUserData(User user) {
		kafkaTemplate.send("user-topic", user.getName(), user);
	}

}
