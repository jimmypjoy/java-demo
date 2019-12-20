package com.samples;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Set;

public class Java8DateTime {

	public static void main(String[] args) {
		////////
		LocalDate date1 = LocalDate.of(2018, 1, 1);
		System.out.println(date1);
		System.out.println(date1.isLeapYear());
		System.out.println(date1.plusDays(10));

		System.out.println(LocalDateTime.now());
		LocalTime localTime = LocalTime.of(10, 30);
		Period period = Period.ofWeeks(1);
		System.out.println(localTime);
		//
		LocalDateTime before = LocalDateTime.now();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LocalDateTime after = LocalDateTime.now();
		Duration duration = Duration.between(before, after);
		System.out.println(duration.getSeconds());
		// Time Zones
		Set<String> availableZoneIdSet = ZoneId.getAvailableZoneIds();
		availableZoneIdSet.stream().forEach(System.out::println);

	}

}
