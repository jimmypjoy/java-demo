package com.demo.safevarargs;

import java.util.ArrayList;
import java.util.List;

public class SafeVarargsDemo {
	// commenting below annotation will give a warning
	@SafeVarargs
	private final void print(List<String>... topics) {
		Object[] objArray = topics;
		// below line will cause runtime exception
//		 objArray[0] = List.of(1, 2);
		objArray[0] = List.of("1", "2");

		for (List<String> topic : topics) {
			for (String str : topic) {
				System.out.print(str + "	");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("OOPS");
		list.add("COLLECTION");
		List<String> list1 = new ArrayList<>();
		list1.add("str1");
		list1.add("str2");

		SafeVarargsDemo safeVarargsDemo = new SafeVarargsDemo();
		safeVarargsDemo.print(list, list1);
	}
}
