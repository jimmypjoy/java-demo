package com.samples.java;

public class SwitchSample {
	public static void main(String[] args) {
		String mode = "d";

		int result = switch (mode) {
		case "a", "b":
			yield 1;
		case "c":
			yield 2;
		case "d", "e", "f":
			System.out.println("Supports multi line block!");
			yield 3;
		default:
			yield -1;
		};

		System.out.println(result);	

	}
}
