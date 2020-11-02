package com.samples.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSample {
	public static void main(String[] args) {

		Lock lock = new ReentrantLock();
		lock.lock();
		System.out.println("locked...");
		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
			System.out.println("unlocked...");
		}
	}

}
