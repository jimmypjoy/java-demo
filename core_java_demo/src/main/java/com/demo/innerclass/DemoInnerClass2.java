package com.demo.innerclass;

public class DemoInnerClass2 {
	private int x = 10;

	class B {
		private int x = 20;

		class C {
			private int x = 30;

			public void allTheX() {
				System.out.println(x); // 30
				System.out.println(this.x); // 30
				System.out.println(B.this.x); // 20
				System.out.println(DemoInnerClass2.this.x); // 10
			}
		}
	}

	public static void main(String[] args) {
		DemoInnerClass2 a = new DemoInnerClass2();
		DemoInnerClass2.B b = a.new B();
		DemoInnerClass2.B.C c = b.new C();
		c.allTheX();
	}
}
