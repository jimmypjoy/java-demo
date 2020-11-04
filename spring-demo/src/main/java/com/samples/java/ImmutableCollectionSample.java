package com.samples.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableCollectionSample {
	public static void main(String[] args) {
		List<String> strList = List.of("str1", "str2", "str3");
		try {
			// below line will throw exception
			strList.add("t");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(strList);
		List<String> strList1 = new ArrayList<String>();

		strList1.add("str4");
		strList1.add("str5");
		List<String> strList2 = Collections.unmodifiableList(strList1);
		try {
			// below line will throw exception
			strList2.add("t");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(strList2);

		System.out.println();
	}
}
