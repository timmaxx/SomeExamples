package headfirst.designpatterns.timmax.chapter01.p05;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;


	void swim() {
		System.out.println("Duck can swim");
	}

	abstract void display();

	void performFly() {
		flyBehavior.fly();
	}

	void performQuack() {
		quackBehavior.quack();
	}
}