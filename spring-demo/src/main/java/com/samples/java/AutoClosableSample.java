package com.samples.java;

class Resource1 implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("Resource1 close");
		throw new RuntimeException("Exception in Resource1:: close");
	}
}

class Resource2 implements AutoCloseable {
	@Override
	public void close() {
		System.out.println("Resource2 close");
		throw new RuntimeException("Exception in Resource2:: close");
	}
}

public class AutoClosableSample {
	public static void main(String[] args) {
		try (Resource1 r1 = new Resource1(); Resource2 r2 = new Resource2()) {
			System.out.println("Test");
			throw new RuntimeException("From main");
		} catch (Exception e) {
			System.out.println("catch exception");
			e.printStackTrace();
			if (e.getSuppressed() != null) {
				System.out.println("##Suppressed exceptions-");
				for (Throwable t : e.getSuppressed()) {
					System.out.println(t);
				}
			}
		} finally {
			System.out.println("Finally");
		}
	}
}
