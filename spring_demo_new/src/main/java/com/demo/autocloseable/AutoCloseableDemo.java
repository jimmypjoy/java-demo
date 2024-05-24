package com.demo.autocloseable;

public class AutoCloseableDemo {

	public static void main(String[] args) {

		final MyWorker worker = new MyWorker();
		
		try (worker) {
			worker.doSomething();
		} catch (Exception e) { 

		}
	}

}
