package com.demo.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

	private final ReentrantLock lock = new ReentrantLock();
	private int counter = 0;

	public void increment() {
		lock.lock(); // Acquiring the lock
		try {
			counter++;
			System.out.println(Thread.currentThread().getName() + " incremented counter to: " + counter);
		} finally {
			lock.unlock(); // Releasing the lock
		}
	}

	public static void main(String[] args) {
		LockDemo lockDemo = new LockDemo();
		Runnable task = lockDemo::increment;

		Thread t1 = new Thread(task, "Thread-1");
		Thread t2 = new Thread(task, "Thread-2");

		t1.start();
		t2.start();
	}

}
