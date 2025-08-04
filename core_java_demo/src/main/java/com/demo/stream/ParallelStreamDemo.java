package com.demo.stream;

import java.util.List;

public class ParallelStreamDemo {
	public static void main(String[] args) {
		nonparallel();
		parallel();
	}

	public static void nonparallel() {
		long start = System.currentTimeMillis();
		List.of(1, 2, 3, 4, 5).stream().map(w -> doWork(w)).forEach(s -> System.out.print(s + " "));

		System.out.println();
		var timeTaken = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Time: " + timeTaken + " seconds");

	}
	
	public static void parallel() {
		long start = System.currentTimeMillis();
		List.of(1, 2, 3, 4, 5).parallelStream().map(w -> doWork(w)).forEach(s -> System.out.print(s + " "));

		System.out.println();
		var timeTaken = (System.currentTimeMillis() - start) / 1000;
		System.out.println("Time: " + timeTaken + " seconds");

	}

	private static int doWork(int input) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		return input * 2;
	}

}
