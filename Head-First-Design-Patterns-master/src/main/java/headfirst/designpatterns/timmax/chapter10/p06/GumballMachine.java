package headfirst.designpatterns.timmax.chapter10.p06;

import headfirst.designpatterns.timmax.chapter10.p06.inners.StateOfGumballMachine;

public class GumballMachine implements IState {
	private final IState iState;

	public GumballMachine(int numberGumballs) {
		iState = new StateOfGumballMachine(numberGumballs);
	}

	// Implemented methods of interface IState:
	@Override
	public void insertQuarter() {
		iState.insertQuarter();
	}

	@Override
	public void ejectQuarter() {
		iState.ejectQuarter();
	}

	@Override
	public void turnCrank() {
		iState.turnCrank();
	}

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return iState.toString();
	}
}
