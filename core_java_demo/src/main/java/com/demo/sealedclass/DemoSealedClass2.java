package com.demo.sealedclass;

abstract sealed class Fish permits Trout, Bass {
}

final class Trout extends Fish {
}

final class Bass extends Fish {
}

public class DemoSealedClass2 {

	public static void main(String[] args) {

		System.out.println(getType(new Bass()));
	}

	public static String getType(Fish fish) {
		return switch (fish) {
		case Trout t -> "Trout!";
		case Bass b -> "Bass!";
		};
	}

}
