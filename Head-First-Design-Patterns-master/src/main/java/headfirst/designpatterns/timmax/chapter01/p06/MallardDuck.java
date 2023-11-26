package headfirst.designpatterns.timmax.chapter01.p06;

public class MallardDuck extends Duck {
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}

	public void display() {
		System.out.println("I'm MallardDuck");
	}
}