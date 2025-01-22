package com.demo.sealedinterface;

public final class Doctor implements Employee {
	@Override
	public void performDuties() {
		System.out.println("Performing doctor's duties");
	}
}