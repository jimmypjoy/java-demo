package com.demo.resources;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleDemo {

	public static void main(String[] args) {

		// Define the locale (e.g., Locale.FRENCH for French, Locale.ENGLISH for
		// English)
		Locale locale_fr = Locale.FRENCH; // Change this to Locale.ENGLISH to read from the default properties file

		// Load the resource bundle for the given locale
		ResourceBundle bundle = ResourceBundle.getBundle("messages", locale_fr);

		// Read and print properties
		String greeting = bundle.getString("greeting");
		String farewell = bundle.getString("farewell");

		System.out.println("Greeting: " + greeting);
		System.out.println("Farewell: " + farewell);

//		Locale locale_us = Locale.US;
		ResourceBundle bundle2 = ResourceBundle.getBundle("messages");
		greeting = bundle2.getString("greeting");
		farewell = bundle2.getString("farewell");

		System.out.println("Greeting: " + greeting);
		System.out.println("Farewell: " + farewell);
	}
}