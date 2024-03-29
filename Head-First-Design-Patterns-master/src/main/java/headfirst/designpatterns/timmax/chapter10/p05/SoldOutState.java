package headfirst.designpatterns.timmax.chapter10.p05;

public class SoldOutState extends AState {
	public SoldOutState(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	@Override
	public void insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You can't eject, you haven't inserted a quarter yet");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but there are no gumballs");
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	@Override
	public void refill() {
		stateOfGumballMachine.setState(stateOfGumballMachine.getNoQuarterState());
	}

	@Override
	public String toString() {
		return "sold out";
	}
}
