package headfirst.designpatterns.timmax.chapter10.p05;

public interface State {
	void insertQuarter();
	void ejectQuarter();
	void turnCrank();

	void dispense();
	void refill();
}
