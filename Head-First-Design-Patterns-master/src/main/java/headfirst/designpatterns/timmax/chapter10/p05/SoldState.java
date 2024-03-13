package headfirst.designpatterns.timmax.chapter10.p05;

public class SoldState extends AState {
	public SoldState(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you already turned the crank");
	}

	@Override
	public void turnCrank() {
		System.out.println("Turning twice doesn't get you another gumball!");
	}

	@Override
	public void dispense() {
		stateOfGumballMachine.releaseBall();
		if (stateOfGumballMachine.getCount() > 0) {
			stateOfGumballMachine.setState(stateOfGumballMachine.getNoQuarterState());
		} else {
			System.out.println("Oops, out of gumballs!");
			stateOfGumballMachine.setState(stateOfGumballMachine.getSoldOutState());
		}
	}

	@Override
	public void refill() { }

	@Override
	public String toString() {
		return "dispensing a gumball";
	}
}
