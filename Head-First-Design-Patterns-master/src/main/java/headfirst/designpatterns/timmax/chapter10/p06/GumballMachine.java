package headfirst.designpatterns.timmax.chapter10.p06;

public class GumballMachine implements State {
	private StateOfGumballMachine stateOfGumballMachine;

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
		StringBuilder result = new StringBuilder();
		result.append("Mighty Gumball, Inc.\n");
		result.append("Java-enabled Standing Gumball Model #2004\n");
		result.append("Inventory: ").append(stateOfGumballMachine.getCount()).append(" gumball");
		if (stateOfGumballMachine.getCount() != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is ").append(stateOfGumballMachine.getCount()).append("\n");
		return result.toString();
	}
}
