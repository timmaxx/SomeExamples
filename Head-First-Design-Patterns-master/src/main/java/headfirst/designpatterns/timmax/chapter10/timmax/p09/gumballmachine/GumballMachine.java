package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement.GumballMachineStateContext;

public class GumballMachine implements IStateOfGumballMachine {
	private final IStateOfGumballMachine stateContext;

	public GumballMachine() {
		stateContext = new GumballMachineStateContext();
	}

	// Implemented methods of interface IStateOfGumballMachine:
	@Override
	public void insertCoin() {
		stateContext.insertCoin();
	}

	@Override
	public void ejectCoin() {
		stateContext.ejectCoin();
	}

	@Override
	public void turnCrank() {
		stateContext.turnCrank();
	}

	@Override
	public void refillGumballBox() {
		stateContext.refillGumballBox();
	}

	@Override
	public void pullOutAllCoins() {
		stateContext.pullOutAllCoins();
	}

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return stateContext.toString();
	}
}
