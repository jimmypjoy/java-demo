package com.samples;

import java.io.File;
import java.io.IOException;

public class NavigateFileAndFolders {
	public static void main(String[] args) throws IOException {
		// print all .java files
		navigateFiles(new File("C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\java\\com\\samples"),
				".java");
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

}
