package com.samples;

public class InstantiationDemo {

	public static String str1 = "str1";

	static {
		str1 = "str2";
	}

	public static void main(String[] args) {
		System.out.println(str1);

	}

}
