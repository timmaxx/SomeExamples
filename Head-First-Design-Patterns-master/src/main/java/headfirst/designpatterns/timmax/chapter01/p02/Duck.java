package headfirst.designpatterns.timmax.chapter01.p02;

public abstract class Duck {
	public void quack() {
		System.out.println("Quack");
	}

	public void swim() {
		System.out.println("Duck can swim");
	}

	public void fly() {
		System.out.println("Duck can fly");
	}

	public abstract void display();
}
