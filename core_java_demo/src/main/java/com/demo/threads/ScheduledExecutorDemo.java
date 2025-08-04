package com.demo.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorDemo {
	public static void main(String[] args) throws Exception {
		try (var service = Executors.newSingleThreadScheduledExecutor()) {
			Runnable task1 = () -> System.out.println("Hello Zoo");
			Callable<String> task2 = () -> "Monkey";
			ScheduledFuture<?> r1 = service.schedule(task1, 4, TimeUnit.SECONDS);
			ScheduledFuture<?> r2 = service.schedule(task2, 3, TimeUnit.SECONDS);

			System.out.println("######" + r2.get());
			System.out.println("######" + r1.get());

		}
	}
}
