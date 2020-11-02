package com.samples.java;

import java.util.function.BiPredicate;

public class BiPredicateSample {
	public static void main(String[] args) {
		String[] arr = { "A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab" };
		BiPredicate<String, String> predicate = String::startsWith;

		for (String str : arr) {
			if (predicate.test(str, "A"))
				System.out.println(str);
		}

		///
		BiPredicate<String, String> predicate2 = String::equalsIgnoreCase;
		System.out.println(predicate2.test("JaVa", "Java"));

		BiPredicate<String, String> biPredicate3 = (str1, str2) -> str1.contains(str2);
		System.out.println(biPredicate3.test("Java", "J"));
	}
}
