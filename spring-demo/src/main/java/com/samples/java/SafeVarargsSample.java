package com.samples.java;

import java.util.ArrayList;
import java.util.List;

public class SafeVarargsSample {
	// commenting below annotation will give a warning
	@SafeVarargs
	private void print(List<String>... topics) {
		Object[] objArray = topics;
		// below line will cause runtime exception
		// objArray[0] = List.of(1, 2);
		objArray[0] = List.of("1", "2");

		for (List<String> topic : topics) {
			for (String str : topic) {
				System.out.print(str + "	");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		SafeVarargsSample safeVarargsSample = new SafeVarargsSample();
		List<String> list = new ArrayList<>();
		list.add("OOPS");
		list.add("COLLECTION");
		List<String> list1 = new ArrayList<>();
		list1.add("str1");
		list1.add("str2");
		safeVarargsSample.print(list, list1);
	}

}
