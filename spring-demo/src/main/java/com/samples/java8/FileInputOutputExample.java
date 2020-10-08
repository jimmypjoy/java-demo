package com.samples.java8;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
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
			// print methods in BasicFileAttributes
			testFileProperties();

		}

	}

	public static void testFileProperties() {
		try {

			Path path = Paths.get(
					"C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\inputs\\new_file.txt");

			// loop over BasicFileAttributes
			BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
			Class<BasicFileAttributes> cl = BasicFileAttributes.class;
			for (Method method : cl.getMethods()) {
				System.out.println(method.getName() + "::" + method.invoke(basicFileAttributes));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
