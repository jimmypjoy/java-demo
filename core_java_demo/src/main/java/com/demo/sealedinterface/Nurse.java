package com.demo.sealedinterface;

public final class Nurse implements Employee {
	@Override
	public void performDuties() {
		System.out.println("Performing nurse's duties");
	}
}
