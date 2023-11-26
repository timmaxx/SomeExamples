package headfirst.designpatterns.timmax.chapter01.p03;

public class RubberDuck extends Duck implements Quackable {
	@Override
	public void quack() {
		System.out.println("Mmm...");
	}

	public void display() {
		System.out.println("I'm RubberDuck");
	}
}