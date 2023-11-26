package headfirst.designpatterns.timmax.chapter01.p05;

public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
