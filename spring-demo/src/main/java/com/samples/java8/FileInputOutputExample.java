package com.samples.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileInputOutputExample {
	public static void main(String[] args) {

		Path path = Paths.get(
				"C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\inputs\\testfileinput.txt");
		try {
			Files.lines(path).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner scanIn = new Scanner(System.in);
		while (true) {
			System.out.println("Enter input: ");
			String input = scanIn.nextLine();

			if ("end".equals(input)) {
				System.out.println("Exiting");
				scanIn.close();
				System.exit(0);
			}

			System.out.println("output:" + input.toUpperCase());
		}

	}
}
