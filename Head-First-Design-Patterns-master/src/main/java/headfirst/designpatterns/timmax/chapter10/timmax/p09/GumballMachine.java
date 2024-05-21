package headfirst.designpatterns.timmax.chapter10.timmax.p09;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.inners.GumballMachineStateContext;

public class GumballMachine implements IStateOfGumballMachine {
	private final IStateOfGumballMachine stateContext;

	public GumballMachine() {
		stateContext = new GumballMachineStateContext();
	}

	// Implemented methods of interface IStateOfGumballMachine:
	@Override
	public void insertQuarter() {
		stateContext.insertQuarter();
	}

	@Override
	public void ejectQuarter() {
		stateContext.ejectQuarter();
	}

	@Override
	public void turnCrank() {
		stateContext.turnCrank();
	}

	@Override
	public void refill() {
		stateContext.refill();
	}

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return stateContext.toString();
	}
}
