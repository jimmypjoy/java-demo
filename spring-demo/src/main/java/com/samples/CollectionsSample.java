package com.samples;

import java.util.NavigableMap;
import java.util.TreeMap;

public class CollectionsSample {
	public static void main(String[] args) {
		NavigableMap<Integer, String> map = new TreeMap<>();
		map.put(25, "New York");
		map.put(32, "Jersey City");
		map.put(11, "Newark");
		map.put(39, "Chicago");
		//headMap(K toKey, boolean inclusive) => returns the map till toKey, if inclusive is true.
		System.out.println(map.headMap(25, true));
	}
}
