package com.demo.threads;

public class SynchronizationDemoThread extends Thread {

	SynchronizationClass sd;
	String str;

	SynchronizationDemoThread(SynchronizationClass sd, String str) {
		this.sd = sd;
		this.str = str;
	}

	public void run() {
		sd.synchronizedMehod1(str);
	}
}