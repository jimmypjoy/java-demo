package com.demo.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class NIODemo extends SimpleFileVisitor<Path> {
	public static void main(String[] args) throws Exception {
		boolean newFile = false;
		File file1 = new File(
				"C:\\gitworkspace\\java-demo\\core_java_demo\\src\\main\\resources\\inputs\\new_file.txt");

		System.out.println(file1.exists());

		FileWriter fileWriter = new FileWriter(file1);
		fileWriter.write("hello \nhow r u?");
		fileWriter.flush();
		fileWriter.close();
		System.out.println(file1.exists());
		System.out.println(newFile);

		// FileReader
		File fileInput = new File(
				"C:\\gitworkspace\\java-demo\\core_java_demo\\src\\main\\resources\\inputs\\testfileinput.txt");
		FileReader fileReader = new FileReader(fileInput);
		char[] in = new char[500];
		fileReader.read(in);
		for (char c : in) {
			System.out.print(c);
		}
		fileReader.close();

//		BufferedReader
		FileReader fileReader1 = new FileReader(fileInput);
		BufferedReader bufferedReader = new BufferedReader(fileReader1);
		String currentLine = null;
		while ((currentLine = bufferedReader.readLine()) != null) {
			System.out.println(currentLine);

		}
		bufferedReader.close();

		// FileVisitResult
		Files.walkFileTree(Paths.get("C:\\gitworkspace\\java-demo\\spring_demo_new\\src\\main\\java\\com\\demo\\nio"),
				new NIODemo());
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.getFileName().toString().endsWith(".java")) {
			System.out.println(file.getFileName().toString());
		}
		return FileVisitResult.CONTINUE;
	}
}
