package com.demo.threads;

public class SynchronizationClass {

	public void synchronizedMehod1(String param1) {

		System.out.println("non synchronized part of method: " + param1);
		synchronized (this) {
			for (int i = 0; i < 5; i++) {
				System.out.println("Inside SynchronizationClass.synchronizedMehod1() with parameter: " + param1);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} //
	}
}
