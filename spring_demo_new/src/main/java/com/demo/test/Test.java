package com.demo.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class Test {
	public static void main(String[] args) {
		String nonNullValue = null;
		Stream<String> nonNullStream = Stream.of(nonNullValue);
		nonNullStream.forEach(System.out::println);
	}
}
