package com.samples;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class Java8DateTime {

	public static void main(String[] args) {
		System.out.println(LocalDateTime.now());
		LocalTime localTime = LocalTime.of(10, 30);
		Period period = Period.ofWeeks(1);
		System.out.println(localTime);

	}

}
