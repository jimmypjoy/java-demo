package com.samples.java8;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariablesSample {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(10);
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.addAndGet(2));
	}
}
