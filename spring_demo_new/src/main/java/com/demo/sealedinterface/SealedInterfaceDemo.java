package com.demo.sealedinterface;

public class SealedInterfaceDemo {
	public static void main(String[] args) {
		Employee doctor = new Doctor();
		Employee nurse = new Nurse();

		doctor.performDuties();
		nurse.performDuties();

	}
}
