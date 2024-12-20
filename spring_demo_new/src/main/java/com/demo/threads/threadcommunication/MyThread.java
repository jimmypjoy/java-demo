package com.demo.threads.threadcommunication;

public class MyThread extends Thread {

	int total;

	@Override
	public void run() {

		System.out.println("Child Thread is calculating the sum:");

		synchronized (this) {
			for (int i = 1; i <= 5; i++) {
				total += i;
			}
			this.notify();
		}

	}
}
