package com.demo.innerclass;

public class StaticInnerClassDemo {

	static class Ride{
		private int price;
	}
	
	public static void main(String[] args) {
		var ride = new Ride();
		System.out.println(ride.price);
	}
}
