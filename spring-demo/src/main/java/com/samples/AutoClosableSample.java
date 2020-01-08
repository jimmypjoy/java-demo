package com.samples;

class Resource1 implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("Resource1");
	}
}

class Resource2 implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("Resource2");
	}
}

public class AutoClosableSample {
	public static void main(String[] args) {
		try (Resource1 r1 = new Resource1(); Resource2 r2 = new Resource2()) {
			System.out.println("Test");
		}
	}
}
