package com.samples.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDemo {
	public static void main(String[] args) {
		int res = 1;
		IntStream stream = IntStream.rangeClosed(1, 5);
		System.out.println(stream.reduce(1, (i, j) -> i * j));

		// convert to set
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
		 * List<Integer> l2 = new ArrayList<>(); for (Integer i : l1) { if (i % 2 == 0)
		 * { l2.add(i); } }
		 */

		List<Integer> l2 = l1.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());

		System.out.println(l2);

		long count = l1.stream().filter(i -> i % 2 == 0).count();
		System.out.println("Number of even numbers: " + count);

		Comparator<Integer> comp = (i1, i2) -> i1.compareTo(i2);

		List<Integer> l3 = l1.stream().sorted(comp).collect(Collectors.toList());
		System.out.println(l3);

		Integer max = l1.stream().max(comp).get();
		System.out.println(max);
		Integer min = l1.stream().min(comp).get();
		System.out.println(min);

		l1.stream().forEach(i -> System.out.println(i));
		///////////////////
		// Reading from File
		Path path = Paths.get(
				"C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\inputs\\testfileinput.txt");
		try {
			Files.lines(path).forEach(line -> System.out.println(line.toUpperCase()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		/////////
		// map-filter-reduce
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		list.stream().map((Integer i1) -> i1.intValue() + ": s")
				.filter(((Predicate<String>) s -> s.startsWith("1")).negate()).forEach(System.out::println);

		IntStream list1 = IntStream.of(1, 2, 3, 4);
		OptionalDouble optionalDouble = list1.map(i -> i * i).filter(i -> i > 4).average();
		if (optionalDouble.isPresent()) {
			System.out.println(optionalDouble.getAsDouble());
		}
		/////////////////////////////////////////////
		List<String> listStr = Arrays.asList("java", "java 8", "pyhon 3", "python", "c", "c++", "java", "python");
		System.out.println(listStr.stream().anyMatch(s -> s.equalsIgnoreCase("python")));
		System.out.println(listStr.stream().allMatch(s -> s.equalsIgnoreCase("python")));
		Optional<String> opt = listStr.stream().filter(s -> s.equalsIgnoreCase("python")).findAny();
		opt.ifPresent(s -> System.out.println(s));
		listStr.stream().peek(System.out::println).filter(s -> s.equalsIgnoreCase("c++")).findAny();

		// Collectors
		System.out.println(listStr.stream().collect(Collectors.counting()));
		System.out.println(listStr.stream().collect(Collectors.joining(":")));
		Optional<String> optLongest = listStr.stream().collect(Collectors.maxBy((s1, s2) -> s1.length() - s2.length()));
		System.out.println("Longest string is: " + optLongest.get());

		// iterate
		Stream.iterate(0, i -> i + 1).limit(5).forEach(System.out::println);

		// Parallel streams
		LongStream stream1 = LongStream.rangeClosed(1, 10_000_00000);
		long start = System.currentTimeMillis();
		System.out.println(stream1.sum());
		long end = System.currentTimeMillis();
		System.out.println("Time taken-non parallel:" + (end - start));

		LongStream streamParallel = LongStream.rangeClosed(1, 10_000_00000).parallel();
		start = System.currentTimeMillis();
		System.out.println(streamParallel.sum());
		end = System.currentTimeMillis();
		System.out.println("Time taken- parallel:" + (end - start));
		//
		LongStream.rangeClosed(1, 10).parallel()
				.peek((i) -> System.out.println(i + " :" + Thread.currentThread().getName())).count();

	}
}
