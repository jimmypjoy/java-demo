package com.samples.java8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicVariablesSample {
	public static void main(String[] args) {
		AtomicInteger atomicInteger = new AtomicInteger(9);
		System.out.println(atomicInteger.getAndIncrement());
		System.out.println(atomicInteger.addAndGet(2));
		System.out.println(atomicInteger.compareAndSet(9, 10));

		System.out.println(atomicInteger.updateAndGet(i -> 5 * i));
		System.out.println(atomicInteger.accumulateAndGet(2, (i1, i2) -> i1 + i2));

		AtomicReference<String> atomicReference = new AtomicReference<>("test jj");
		System.out.println(atomicReference.updateAndGet(s -> s.toUpperCase()));
		System.out.println(atomicReference.accumulateAndGet("hi ..", ((s1, s2) -> s2 + s1)));
	}
}
