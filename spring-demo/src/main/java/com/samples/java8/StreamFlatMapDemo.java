package com.samples.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFlatMapDemo {
	public static void main(String[] args) {
		Path path = Paths.get(
				"C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\inputs\\testfileinput.txt");
		try {
			// printing each word in ecah line using flatMap/Stream of Streams
			Files.lines(path).map(line -> line.split(" ")).flatMap(array -> Arrays.stream(array))
					.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

		//////////
		List<String> list = Arrays.asList("Geeks", "GFG", "GeeksforGeeks", "gfg");
		// Using Stream flatMap(Function mapper)
		list.stream().flatMap(str -> Stream.of(str.charAt(2))).forEach(System.out::println);
	}
}
