package com.samples.java8;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
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
		System.out.println("Time Zones");
		Set<String> availableZoneIdSet = ZoneId.getAvailableZoneIds();
		availableZoneIdSet.stream().forEach(System.out::println);
		// format
		System.out.println("format");
		LocalDateTime date = LocalDateTime.of(2019, 1, 1, 10, 10);
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(formatter.format(date));
		//////////// Adding date
		System.out.println("Adding date");
		LocalTime t1 = LocalTime.parse("11:03:15.987");
		System.out.println(t1.plus(22, ChronoUnit.HOURS).equals(t1.plusHours(22)));

		LocalDate dateEpoch = LocalDate.ofEpochDay(0);
		System.out.println(dateEpoch);

	}

}