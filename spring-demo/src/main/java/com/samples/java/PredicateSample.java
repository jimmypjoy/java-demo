package com.samples.java;

import java.util.function.Predicate;

public class PredicateSample {
	public static void main(String[] args) {
		Predicate<String> testStartforVowel = (str) -> str.startsWith("a") || str.startsWith("e") || str.startsWith("i")
				|| str.startsWith("o") || str.startsWith("u");

		System.out.println(testStartforVowel.test("aa"));
		System.out.println(testStartforVowel.test("bb"));
		
		Predicate<String> testTwoLetterWord = (str) -> str.length()==2;
		
		System.out.println(testStartforVowel.and(testTwoLetterWord).test("aa"));
		System.out.println(testStartforVowel.and(testTwoLetterWord).test("aaaa"));
		//
		 
	}
}
