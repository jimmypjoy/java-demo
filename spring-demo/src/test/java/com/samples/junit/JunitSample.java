package com.samples.junit;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class JunitSample {

	@BeforeEach
	public void setup() {
		System.out.println("Setup");

	}

	@Test
	public void greetShouldRetunAValidOutput() {
		System.out.println("greetShouldRetunAValidOutput");
//		Assertions.assertEquals("Test1", "Test");
	}

	@AfterEach
	public void teardown() {
		System.out.println("teardown");
	}

}
