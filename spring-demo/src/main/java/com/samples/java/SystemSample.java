package com.samples.java;

public class SystemSample {
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		int cpus = rt.availableProcessors();
		System.out.println("Number of CPUs: " + cpus);
	}
}
