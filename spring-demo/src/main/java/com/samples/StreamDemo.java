package com.samples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		int res = 1;
		IntStream stream = IntStream.rangeClosed(1, 5);
		System.out.println(stream.reduce(1, (i, j) -> i * j));

		// conevrt to set
		Stream<String> stream2 = Stream.of("java", "python", "c", "c++", "java", "python");
		Set<String> set = stream2.collect(Collectors.toSet());
		System.out.println(set);
		/////////////////////
		List<Integer> l1 = new ArrayList<>();

		for (int i = 0; i <= 10; i++) {
			l1.add(i);
		}

		System.out.println(l1);

		/*
		 * List<Integer> l2 = new ArrayList<>(); for (Integer i : l1) { if (i %
		 * 2 == 0) { l2.add(i); } }
		 */

		List<Integer> l2 = l1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

		System.out.println(l2);
		
		
		long count = l1.stream().filter(i -> i % 2 == 0).count();
		System.out.println("Number of even numbers are: "+count);
		
		Comparator<Integer> comp = (i1,i2)->i1.compareTo(i2);
		
		List<Integer> l3 = l1.stream().sorted(comp).collect(Collectors.toList());
		System.out.println(l3);
		
		Integer max = l1.stream().max(comp).get();
		System.out.println(max);
		Integer min = l1.stream().min(comp).get();
		System.out.println(min);
		
		l1.stream().forEach(i->System.out.println(i));
		///////////////////
	}
}
