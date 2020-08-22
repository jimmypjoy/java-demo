package com.samples.java8;

public class LamdaExample {
	public static void main(String[] args) {
		//////////
		int testVariable1 = 10;
		// multiline lamda sample
		ActionAfterClick2 actionAfterClick2 = (i1, i2) -> {
			int i3 = 5;
			return i1 * i2;
		};
		System.out.println(actionAfterClick2.action2(10, 15));
		////////////////////////
		ActionAfterClick x = () -> {
			System.out.println("I'm action from anonymousclass");
		};

		ActionAfterClick2 x2 = (a, b) -> a + b;

		x.action();
		System.out.println(x2.action2(10, 20));

		Button p = new Button();
		Button p2 = new Button();

		p2.addAction(new ActionAfterClick() {

			@Override
			public void action() {
				System.out.println("I'm action from anonymous class for button p2");
			}
		});
		p.addAction(x);

		int result = p.addAction2(10, 15, x2);

		System.out.println(result);
	}
}

interface ActionAfterClick // REPRESENTS BEHAVIOUR
{
	void action();

}

interface ActionAfterClick2 {
	int action2(int a, int b);
}

class Button {
	void addAction(ActionAfterClick a) {

		a.action();//
	}

	int addAction2(int x, int y, ActionAfterClick2 a) {
		return a.action2(x, y);
	}
}
