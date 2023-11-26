package headfirst.designpatterns.timmax.chapter01.p01;

public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck1 = new MallardDuck();
		RedheadDuck duck2 = new RedheadDuck();

		duck1.display();
		duck1.swim();
		duck1.quack();
		System.out.println();

		duck2.display();
		duck2.swim();
		duck2.quack();
		System.out.println();
	}
}