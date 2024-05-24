package com.demo;

public class GarbageCollectorDemo {

	int objId;

	GarbageCollectorDemo(int objId) {
		this.objId = objId;
		System.out.println("Created " + this.objId);
	}

	public static void main(String[] args) {

		new GarbageCollectorDemo(1);
		new GarbageCollectorDemo(2);

		for (int i = 1; i <= 100; i++) {
			System.out.println("i: " + i);
			System.gc();
		}

	}

	@Override
	protected void finalize() {
		System.out.println("Finalized " + objId);
	}

}
