package com.demo;

import java.util.Map;
import java.util.WeakHashMap;

class User {

	@Override
	public String toString() {

		return "User";

	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println("Finalize Called");

	}
}

public class WeakHashMapDemo {

	public static void main(String[] args) throws InterruptedException {

		Map<User, String> map = new WeakHashMap<>();

		User u = new User(); // 123
		map.put(u, "Tom");

		System.out.println(map);

		u = null;

		System.gc();
		Thread.sleep(5000);

		System.out.println(map);

	}

}
