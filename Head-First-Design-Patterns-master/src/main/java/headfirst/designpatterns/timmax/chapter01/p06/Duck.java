package headfirst.designpatterns.timmax.chapter01.p06;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;


	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

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