package headfirst.designpatterns.timmax.chapter01.p05;

public class RubberDuck extends Duck {
	public RubberDuck() {
		quackBehavior = new Squeak();
		flyBehavior = new FlyNoWay();
	}

	public void display() {
		System.out.println("I'm RubberDuck");
	}
}