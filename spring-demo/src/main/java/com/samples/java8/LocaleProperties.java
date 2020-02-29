package com.samples.java8;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleProperties {
	public static void main(String[] args) {
		Locale loc = new Locale("en", "US");
		ResourceBundle bundle = ResourceBundle.getBundle("localtest.app_properties", loc);
		Enumeration<String> enumeration = bundle.getKeys();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String val = bundle.getString(key);
			System.out.println(key + "=" + val);
		}

	}
}
