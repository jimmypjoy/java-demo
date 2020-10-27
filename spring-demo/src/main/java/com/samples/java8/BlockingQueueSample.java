package com.samples.java8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class BlockingQueueSample {
	public static void main(String[] args) {
		ArrayBlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue<Integer>(2);
		try {

			blockingDeque.offer(1);
			blockingDeque.add(2);
			blockingDeque.put(3);
			System.out.println(blockingDeque);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
