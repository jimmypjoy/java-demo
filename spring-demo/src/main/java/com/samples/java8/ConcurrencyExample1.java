package com.samples.java8;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyExample1 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		Runnable runnable1 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		};

		Runnable runnable2 = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(i);
			}
		};
		executorService.submit(runnable1);
		executorService.submit(runnable2);
		System.out.println("#############################");
		// Callable
		Callable<Integer> callable1= ()->{
			int result =0;
			for (int i = 0; i < 100; i++) {
				result+=i;
				System.out.println(i);
				
			} 
			return result;
		};
		Callable<Integer> callable2= ()->{
			int result =0;
			for (int i = 100; i < 200; i++) {
				result+=i;
				System.out.println(i);
				
			} 
			return result;
		};
		Future<Integer> future1= executorService.submit(callable1);
		Future<Integer> future2= executorService.submit(callable2);
		System.out.println(future1.get());
		
		executorService.shutdown();
	}
}
