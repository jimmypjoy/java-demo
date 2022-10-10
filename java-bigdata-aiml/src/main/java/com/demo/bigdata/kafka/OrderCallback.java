package com.demo.bigdata.kafka;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

public class OrderCallback implements Callback {

	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		System.out.println(metadata.partition());
		System.out.println(metadata.offset());
		System.out.println("Test demo..Kafka message sent successfully");
		if (exception != null) {
			exception.printStackTrace();
		}

	}

}
