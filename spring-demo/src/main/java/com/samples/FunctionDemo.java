package com.samples;

import java.util.function.BiFunction;
import java.util.function.ToIntFunction;

public class FunctionDemo {
	public static void main(String[] args) {
		String text = "Aa aA aB Ba aC Ca";
		ToIntFunction<String> func = text::indexOf;
		System.out.println(func.applyAsInt("a"));
		//BiFunction
		System.out.println("BiFunction");
		BiFunction<String, String, String> bifunc = String::concat;
        System.out.println(bifunc.apply("Jimmy", "Joy"));
        BiFunction<String, String, String> bifunc2 = (str1, str2) -> str1+":"+str2;
        System.out.println(bifunc2.apply("Jimmy", "Joy"));
        //
        BiFunction<Integer, Integer, Integer> compFunc = (i, j) -> i + j;
        System.out.println(compFunc.apply(0, 65));
	}
}
