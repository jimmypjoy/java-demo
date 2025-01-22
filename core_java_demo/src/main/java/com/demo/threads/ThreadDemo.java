package com.demo.threads;

public class ThreadDemo extends Thread {

	static int sum = 0;

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		ThreadDemo td = new ThreadDemo();

		td.setPriority(MAX_PRIORITY);
		td.setName("ThreadDemo-Test Name");
		td.setDaemon(true);
		td.start();
		td.interrupt();
		try {
			td.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Sum of first 5 Numbers is " + ThreadDemo.sum);
		long end = System.currentTimeMillis();

		System.out.println("The total time taken is " + (end - start) / 1000 + " Seconds.");

	}

	public void run() {
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		System.out.println("Thread Priority: " + Thread.currentThread().getPriority());
		System.out.println("Thread isDaemon: " + Thread.currentThread().isDaemon());
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(1000);
				ThreadDemo.sum += i;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(" sum from run: for i=" + i + " :" + ThreadDemo.sum);
		}
	}

}
