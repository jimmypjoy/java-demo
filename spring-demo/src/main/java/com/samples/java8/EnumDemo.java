package com.samples.java8;

public class EnumDemo {
	enum EnumSample {
		SMALL(8),
		MEDIUM(12),
		LARGE(16){
			public String getLidSize() {
				return "Large";
			}
			
		};

		EnumSample(int size) {
			System.out.println("inside the constructor");
			this.size = size;
		}

		private int size;

		public int getSize() {
			return size;
		}
		public String getLidSize() {
			return "Small";
		}
	}

	public static void main(String[] args) {
		System.out.println(EnumSample.LARGE.getSize());
		for (EnumSample enumDemo : EnumSample.values()) {
			System.out.println(enumDemo.toString()+":"+enumDemo.getSize()+":"+enumDemo.getLidSize());
		}

	}

}
