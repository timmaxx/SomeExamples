package headfirst.designpatterns.timmax.chapter10.timmax.p07;

import headfirst.designpatterns.timmax.chapter10.timmax.common.state.StateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p07.inners.StateOfGumballMachine;

public class GumballMachine implements IStateOfGumballMachine {
	private final StateContext stateContext;
	// private final IStateOfGumballMachine iStateOfGumballMachine;

	public GumballMachine(int numberGumballs) {
		stateContext = new StateContext();
		iStateOfGumballMachine = new StateOfGumballMachine(numberGumballs);
	}

	// Implemented methods of interface IStateOfGumballMachine:
	@Override
	public void insertQuarter() {
		iStateOfGumballMachine.insertQuarter();
	}

	@Override
	public void ejectQuarter() {
		iStateOfGumballMachine.ejectQuarter();
	}

	@Override
	public void turnCrank() {
		iStateOfGumballMachine.turnCrank();
	}

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return iStateOfGumballMachine.toString();
	}
}

/*
import headfirst.designpatterns.timmax.chapter10.timmax.p07.inners.StateOfGumballMachine;

public class GumballMachine implements IStateOfGumballMachine {
	private final IStateOfGumballMachine iStateOfGumballMachine;

	public GumballMachine(int numberGumballs) {
		iStateOfGumballMachine = new StateOfGumballMachine(numberGumballs);
	}

	// Implemented methods of interface IStateOfGumballMachine:
	@Override
	public void insertQuarter() {
		iStateOfGumballMachine.insertQuarter();
	}

	@Override
	public void ejectQuarter() {
		iStateOfGumballMachine.ejectQuarter();
	}

	@Override
	public void turnCrank() {
		iStateOfGumballMachine.turnCrank();
	}

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return iStateOfGumballMachine.toString();
	}
}
*/