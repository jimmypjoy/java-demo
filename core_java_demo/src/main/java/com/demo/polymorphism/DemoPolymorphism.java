package com.demo.polymorphism;

class Primate {
	public boolean hasHair() {
		return true;
	}
}

interface HasTail {
	public abstract boolean isTailStriped();
}

public class DemoPolymorphism extends Primate implements HasTail {
	public boolean isTailStriped() {
		return false;
	}

	public int age = 10;

	public static void main(String[] args) {
		DemoPolymorphism lemur = new DemoPolymorphism();
		System.out.println(lemur.age);

		HasTail hasTail = lemur;
		System.out.println(hasTail.isTailStriped());

		Primate primate = lemur;
		System.out.println(primate.hasHair());
	}
}
