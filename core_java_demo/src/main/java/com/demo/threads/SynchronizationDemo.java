package com.demo.threads;

public class SynchronizationDemo {

	public static void main(String[] args) {
		SynchronizationClass sc = new SynchronizationClass();

		SynchronizationDemoThread t1 = new SynchronizationDemoThread(sc, "Steve");
		SynchronizationDemoThread t2 = new SynchronizationDemoThread(sc, "Mark");

		t1.start();
		t2.start();

	}

}
