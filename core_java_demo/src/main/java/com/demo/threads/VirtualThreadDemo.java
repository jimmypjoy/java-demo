package com.demo.threads;

public class VirtualThreadDemo {
	public static void main(String[] args) {
		// Create a virtual thread (not started yet)
		Thread thread = Thread.ofVirtual().unstarted(() -> {
			System.out.println("Hello from virtual thread: " + Thread.currentThread());
		});
		// Start the thread in a separate line
		thread.start();

		// Wait for it to finish (optional)
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
