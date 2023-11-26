package headfirst.designpatterns.timmax.chapter01.p02;

public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck1 = new MallardDuck();
		RedheadDuck duck2 = new RedheadDuck();
		RubberDuck duck3 = new RubberDuck();

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
		duck3.fly();
		System.out.println("Но резиновая утка не может летать!");
		System.out.println();
	}
}