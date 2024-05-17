package headfirst.designpatterns.timmax.chapter10.timmax.p08;

public class GumballMachine implements IStateOfGumballMachine {
	private final GumballMachineStateContext stateContext;

	public GumballMachine(int numberGumballs) {
		stateContext = new GumballMachineStateContext(numberGumballs);
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

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return stateContext.toString();
	}
}
