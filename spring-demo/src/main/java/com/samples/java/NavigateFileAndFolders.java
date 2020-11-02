package com.samples.java;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.stream.Stream;

public class NavigateFileAndFolders {
	public static void main(String[] args) throws IOException {
		// print all .java files
		String folderName = "C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\java\\com\\samples";
		navigateFiles(new File(folderName), ".java");
		navigateFiles2(folderName);
	}

	public static void navigateFiles(File dir, String extension) throws IOException {
		File[] list = dir.listFiles();
		if (list != null && list.length > 0) {
			for (File file : list) {
				if (file.isDirectory()) {
					navigateFiles(file, extension);
				} else if (file.getName().endsWith(extension)) {
					System.out.println(file.getName());
				}
			}
		}
	}

	public static void navigateFiles2(String folderName) throws IOException {
		System.out.println("Printing using Path and Predicate");
		Path root = Paths.get(folderName);
		BiPredicate<Path, BasicFileAttributes> predicate = (p, a) -> !a.isDirectory() && p.toString().endsWith(".java");
		try (Stream<Path> paths = Files.find(root, 2, predicate)) {
			paths.forEach(System.out::println);
		}

	}
}
