package com.samples.java;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
	public static void main(String[] args) {
		// Consumer to display a number
		Consumer<Integer> display = a -> System.out.println(a);
		display.accept(10);

		// Consumer to multiply 2 to every integer of a list
		Consumer<List<Integer>> modify = list -> {
			for (int i = 0; i < list.size(); i++)
				list.set(i, 2 * list.get(i));
		};
		// Consumer to display a list of numbers
		Consumer<List<Integer>> dispList = list -> list.stream().forEach(a -> System.out.print(a + " "));
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		dispList.accept(list);
		//
		System.out.println();
		System.out.println("modify.andThen");
		 modify.andThen(dispList).accept(list); 
	}
}
