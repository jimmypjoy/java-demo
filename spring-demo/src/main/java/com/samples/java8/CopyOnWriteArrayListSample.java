package com.samples.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListSample {
	public static void main(String[] args) {
		CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
		// below line will through java.util.ConcurrentModificationException
//		List<String> list = new ArrayList<>();
		list.add("str1");
		list.add("str2");
		Iterator<String> iterator = list.iterator();
		list.add("str3");
		list.addAllAbsent(Arrays.asList("str3", "str4"));
		list.addIfAbsent("str6");

		System.out.println("#### First iterator####");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("#### Second iterator####");
		Iterator<String> iterator2 = list.iterator();
		while (iterator2.hasNext()) {
			System.out.println(iterator2.next());
		}
	}

}
