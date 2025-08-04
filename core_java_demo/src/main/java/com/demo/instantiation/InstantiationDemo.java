package com.demo.instantiation;

public class InstantiationDemo {

	private String name = "Fluffy";
	{
		System.out.println("setting field");
	}

	public InstantiationDemo() {

		name = "Tiny";
		System.out.println("setting constructor");
	}

	public static void main(String[] args) {
		InstantiationDemo instantiationDemo = new InstantiationDemo();
		System.out.println(instantiationDemo.name);
		System.out.println(Integer.valueOf("F", 16)); // 15
		System.out.println(Integer.valueOf("0677", 11)); 

	}

}
