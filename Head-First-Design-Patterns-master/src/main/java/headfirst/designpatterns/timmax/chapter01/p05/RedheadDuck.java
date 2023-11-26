package headfirst.designpatterns.timmax.chapter01.p05;

public class RedheadDuck extends Duck {
	public RedheadDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public void display() {
		System.out.println("I'm RedheadDuck");
	}
}