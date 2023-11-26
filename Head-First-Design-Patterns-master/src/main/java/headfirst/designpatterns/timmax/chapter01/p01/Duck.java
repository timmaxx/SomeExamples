package headfirst.designpatterns.timmax.chapter01.p01;

public abstract class Duck {
	public void quack() {
		System.out.println("Quack");
	}

	public void swim() {
		System.out.println("Duck can swim");
	}

	public abstract void display();
}
