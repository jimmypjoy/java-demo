package com.demo.springboot.jms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoJMSSender {

//	private final JmsTemplate jmsTemplate;
//	private final String queueName;
//
//	public DemoJMSSender(JmsTemplate jmsTemplate, @Value("${app.jms.queue.name}") String queueName) {
//		this.jmsTemplate = jmsTemplate;
//		this.queueName = queueName;
//	}
//
//	public void sendMessage(String message) {
//		System.out.println("Sending message: " + message + " to queue: " + queueName);
//		jmsTemplate.convertAndSend(queueName, message);
//	}
}
