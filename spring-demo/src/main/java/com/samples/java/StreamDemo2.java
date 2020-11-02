package com.samples.java;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

enum Color {
	RED, YELLOW, GREEN
}

class TrafficLight {
	String msg;
	Color color;

	TrafficLight(String msg, Color color) {
		this.msg = msg;
		this.color = color;
	}

	public String getMsg() {
		return msg;
	}

	public Color getColor() {
		return color;
	}

	public String toString() {
		return "{" + color + ", " + msg + "}";
	}
}

public class StreamDemo2 {
	public static void main(String[] args) {
		TrafficLight tl1 = new TrafficLight("Go", Color.GREEN);
		TrafficLight tl2 = new TrafficLight("Go Now!", Color.GREEN);
		TrafficLight tl3 = new TrafficLight("Ready to stop", Color.YELLOW);
		TrafficLight tl4 = new TrafficLight("Slow Down", Color.YELLOW);
		TrafficLight tl5 = new TrafficLight("Stop", Color.RED);

		List<TrafficLight> list = Arrays.asList(tl1, tl2, tl3, tl4, tl5);

		Map<Color, List<String>> map = list.stream().collect(Collectors.groupingBy(TrafficLight::getColor,
				Collectors.mapping(TrafficLight::getMsg, Collectors.toList())));

		System.out.println(map.get(Color.YELLOW));
	}
}
