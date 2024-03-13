package headfirst.designpatterns.timmax.chapter10.p06;

import headfirst.designpatterns.timmax.chapter10.p06.inners.StateOfGumballMachine;

public class GumballMachine implements State {
	private final State stateOfGumballMachine;

	public GumballMachine(int numberGumballs) {
		stateOfGumballMachine = new StateOfGumballMachine(numberGumballs);
	}

	@Override
	public void insertQuarter() {
		stateOfGumballMachine.insertQuarter();
	}

	@Override
	public void ejectQuarter() {
		stateOfGumballMachine.ejectQuarter();
	}

	@Override
	public void turnCrank() {
		stateOfGumballMachine.turnCrank();
	}

	@Override
	public String toString() {
		return stateOfGumballMachine.toString();
	}
}
