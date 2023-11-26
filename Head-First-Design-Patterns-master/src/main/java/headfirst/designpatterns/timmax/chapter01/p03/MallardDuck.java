package headfirst.designpatterns.timmax.chapter01.p03;

public class MallardDuck extends Duck implements Flyable, Quackable {
	public void display() {
		System.out.println("I'm MallardDuck");
	}

	@Override
	public void fly() {
		System.out.println("Duck can fly");
	}

	@Override
	public void quack() {
		System.out.println("Quack");
	}
}