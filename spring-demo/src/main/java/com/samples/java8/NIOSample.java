package com.samples.java8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class NIOSample extends SimpleFileVisitor<Path> {
	public static void main(String[] args) {
		try {

			boolean newFile = false;
			File file1 = new File(
					"C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\inputs\\new_file.txt");
			System.out.println(file1.exists());
//			newFile = file1.createNewFile();
			// FileWriter
			FileWriter fileWriter = new FileWriter(file1);
			fileWriter.write("hello \nhow r u?");
			fileWriter.flush();
			fileWriter.close();
			System.out.println(file1.exists());
			System.out.println(newFile);
			// FileReader
			File fileInput = new File(
					"C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\inputs\\testfileinput.txt");
			FileReader fileReader = new FileReader(fileInput);
			char[] in = new char[500];
			fileReader.read(in);
			for (char c : in) {
				System.out.print(c);
			}
			fileReader.close();

//			BufferedReader
			FileReader fileReader1 = new FileReader(fileInput);
			BufferedReader bufferedReader = new BufferedReader(fileReader1);
			String currentLine = null;
			while ((currentLine = bufferedReader.readLine()) != null) {
				System.out.println(currentLine);

			}
			bufferedReader.close();

			//////////////////////////////////////////////////////////////////////////
			// NIO2 Java 7 APIs
			Path path = Paths.get(
					"C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\inputs\\new_file.txt");
			System.out.println(path.getFileName());
			System.out.println(path.getName(1));
			System.out.println(path.getNameCount());
			System.out.println(path.getParent());
			System.out.println(path.getRoot());
			System.out.println(path.toString());
			System.out.println(Files.getLastModifiedTime(path));

			// loop over BasicFileAttributes
			BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);
			Class<BasicFileAttributes> cl = BasicFileAttributes.class;
			for (Method method : cl.getMethods()) {
				System.out.println(method.getName() + "::" + method.invoke(basicFileAttributes));
			}

			// FileVisitResult
			Files.walkFileTree(Paths.get("C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src"), new NIOSample());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("completed");

	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (!file.getFileName().toString().endsWith(".java")) {
			System.out.println(file.getFileName().toString());
		}
		return FileVisitResult.CONTINUE;
	}
}
