package com.samples.java8;

public class ThreadSample {
	public static void main(String[] args) {
		Runnable runnable = () -> System.out.println("Sample thread....");
		new Thread(runnable).start();

		System.out.println("Completed...");

	}

}
