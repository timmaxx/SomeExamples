package headfirst.designpatterns.timmax.chapter01.p02;

public class RubberDuck extends Duck {
	@Override
	public void quack() {
		System.out.println("Mmm...");
	}

	public void display() {
		System.out.println("I'm RubberDuck");
	}
}