package com.samples.spring.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationPropertyConfiguration {
	
	@Value("${sample.testexternalurl}")
	private String testProperty;
	
	public String getTestProperty() {
		return testProperty;
	}

	public void setTestProperty(String testProperty) {
		this.testProperty = testProperty;
	}

}
