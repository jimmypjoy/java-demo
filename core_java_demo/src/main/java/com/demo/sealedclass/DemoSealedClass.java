package com.demo.sealedclass;

abstract sealed class Vehicle permits Car, Bike {
	String name;

	public Vehicle(String name) {
		this.name = name;
	}

	public abstract void display();
}

final class Car extends Vehicle {
	public Car(String name) {
		super(name);
	}

	@Override
	public void display() {
		System.out.println("This is a Car: " + name);
	}
}

final class Bike extends Vehicle {
	public Bike(String name) {
		super(name);
	}

	@Override
	public void display() {
		System.out.println("This is a Bike: " + name);
	}
}

//public class DemoSealedClass extends Vehicle{
// Above line will not compile as DemoSealedClass can't extend Vehicle
public class DemoSealedClass {
	public static void main(String[] args) {

	}

}
