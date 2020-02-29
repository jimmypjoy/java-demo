package com.samples.java8;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTestHarness {

	public static void main(String[] args) {
		Scanner scanIn = new Scanner(System.in);
		while (true) {
			System.out.println("Enter your regex: ");
			String regex = scanIn.nextLine();

			if ("end".equals(regex)) {
				System.out.println("Exiting");
				System.exit(0);
			}

			Pattern pattern = Pattern.compile(regex);
			System.out.println("Enter input string to search:");
			String str = scanIn.nextLine();

			Matcher matcher = pattern.matcher(str);

			boolean found = false;
			while (matcher.find()) {
				System.out.println("Found the text:" + matcher.group() + " :starting at index :" + matcher.start()
						+ ":and ending at index:" + matcher.end());

				found = true;
			}

			if (!found) {
				System.out.println("No match found");

			}
		}
	}

}
