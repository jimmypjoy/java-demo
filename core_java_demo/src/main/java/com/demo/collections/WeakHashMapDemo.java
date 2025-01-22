package com.demo.collections;

import java.util.HashMap;
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
//		Map<User, String> map = new HashMap<>();

		User u = new User(); 
		map.put(u, "Tom");

		System.out.println(map);

		u = null;

		System.gc();
		Thread.sleep(5000);

		System.out.println(map);
		

	}

}
