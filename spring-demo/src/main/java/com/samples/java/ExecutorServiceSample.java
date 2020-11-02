package com.samples.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSample {

	public static void main(String[] args) {
		Callable<String> c = new MyCallable();
		ExecutorService ex = Executors.newCachedThreadPool();
		Future<String> f = ex.submit(c); // finishes in the future
		try {
			String v = f.get(); // blocks until done
			System.out.println("Ran:" + v);
		} catch (InterruptedException | ExecutionException iex) {
			System.out.println("Failed");
		}

	}

}

class MyCallable implements Callable<String> {
	@Override
	public String call() {
		return "test return from call";
	}
}
