package com.samples.java8;

import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class ReflectionSample {

	public static void main(String[] args) {
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
