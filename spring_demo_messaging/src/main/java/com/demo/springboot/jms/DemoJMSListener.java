package com.demo.springboot.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class DemoJMSListener {

	@JmsListener(destination = "${app.jms.queue.name}")
	public void receiveMessage(String message) {
		System.out.println("inside receiveMessage of DemoJMSListener: #########");
		System.out.println("Received message from queue: " + message);
	}
}
