package com.demo.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class GreetingImplTest {

	private Greeting greeting;

	@BeforeAll
	public static void setupBeforeAll() {
		System.out.println("Setup before all");

	}

	@BeforeEach
	public void setup() {
		System.out.println("Setup");
		greeting = new GreetingImpl();

	}

	@Test
	public void greetShouldRetunAValidOutput() {
		System.out.println("greetShouldRetunAValidOutput");
		String result = greeting.greet("Junit");
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Junit", result);
	}

	@Test
	public void greetShouldThrowAnException_For_NameIsNull() {
		System.out.println("greetShouldThrowAnException_For_NameIsNull");

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet(null);
		});
	}

	@Test
	public void greetShouldThrowAnException_For_NameIsBlank() {
		System.out.println("greetShouldThrowAnException_For_NameIsBlank");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet("");
		});
	}

	@AfterEach
	public void teardown() {
		System.out.println("teardown");
		greeting = null;
	}

	@AfterAll
	public static void teardownAfterAll() {
		System.out.println("teardown");
	}

}
