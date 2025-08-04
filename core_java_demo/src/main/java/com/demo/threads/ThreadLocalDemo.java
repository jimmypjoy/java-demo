package com.demo.threads;

public class ThreadLocalDemo {
	// Define a ThreadLocal variable to store user ID
	private static final ThreadLocal<String> userId = new ThreadLocal<>();

	public static void main(String[] args) {
		Runnable task1 = () -> {
			userId.set("User-A");
			System.out.println("Thread 1 User ID: " + userId.get());
			userId.remove(); // Always remove to avoid memory leaks
		};

		Runnable task2 = () -> {
			userId.set("User-B");
			System.out.println("Thread 2 User ID: " + userId.get());
			userId.remove();
		};

		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);

		thread1.start();
		thread2.start();
	}
}
