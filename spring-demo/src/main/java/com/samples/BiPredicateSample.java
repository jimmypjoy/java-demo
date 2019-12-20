package com.samples;

import java.util.function.BiPredicate;

public class BiPredicateSample {
	public static void main(String[] args) {
		String[] arr = { "A", "ab", "bab", "Aa", "bb", "baba", "aba", "Abab" };
		BiPredicate<String, String> predicate = String::startsWith;

		for (String str : arr) {
			if (predicate.test(str, "A"))
				System.out.println(str);
		}
	}
}
