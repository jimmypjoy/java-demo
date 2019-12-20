package com.samples;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleProperties {
	public static void main(String[] args) {
		String path = "C:\\gitworkspace\\javademo\\java-demo\\spring-demo\\src\\main\\resources\\localtest\\app_properties";
		File fl = new java.io.File(path);
		URL resourceURL = null;

		Locale loc = new Locale("en", "US");
		try {
			resourceURL = fl.toURI().toURL();
		} catch (MalformedURLException e) {
		}

		URLClassLoader urlLoader = new URLClassLoader(new java.net.URL[] { resourceURL });
		ResourceBundle bundle = java.util.ResourceBundle.getBundle(path, loc, urlLoader);

		Enumeration<String> enumeration = bundle.getKeys();
		while (enumeration.hasMoreElements()) {
			String key = enumeration.nextElement();
			String val = bundle.getString(key);
			System.out.println(key + "=" + val);
		}
	}
}
