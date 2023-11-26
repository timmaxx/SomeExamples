package headfirst.designpatterns.timmax.chapter01.p03;

public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck1 = new MallardDuck();
		RedheadDuck duck2 = new RedheadDuck();
		RubberDuck duck3 = new RubberDuck();
		DecoyDuck duck4 = new DecoyDuck();

		duck1.display();
		duck1.swim();
		duck1.quack();
		duck1.fly();
		System.out.println();

		duck2.display();
		duck2.swim();
		duck2.quack();
		duck2.fly();
		System.out.println();

		duck3.display();
		duck3.swim();
		duck3.quack();
		System.out.println();

		duck4.display();
		duck4.swim();
		System.out.println();
	}
}