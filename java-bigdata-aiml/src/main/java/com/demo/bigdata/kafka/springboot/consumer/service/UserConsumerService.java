package com.demo.bigdata.kafka.springboot.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.bigdata.kafka.springboot.producer.dto.User;

@Service
public class UserConsumerService {

	@KafkaListener(topics = { "user-topic" })
	public void consumerUserData(User user) {
		System.out.println("#####################################");
		System.out.println("Inside Kafka UserConsumerService");
		System.out.println("User name is: " + user.getName() + " Users Age Is: " + user.getAge() + " Fav Genre: "
				+ user.getFavGenre());
		System.out.println("#####################################");
	}
}
