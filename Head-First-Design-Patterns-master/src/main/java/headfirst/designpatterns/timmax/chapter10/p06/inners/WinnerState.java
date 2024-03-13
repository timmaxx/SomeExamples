package headfirst.designpatterns.timmax.chapter10.p06.inners;

public class WinnerState extends AState {
	public WinnerState(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	@Override
	public void insertQuarter() {
		System.out.println("Please wait, we're already giving you a Gumball");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Please wait, we're already giving you a Gumball");
	}

	@Override
	public void turnCrank() {
		System.out.println("Turning again doesn't get you another gumball!");
	}

	@Override
	public void dispense() {
		stateOfGumballMachine.releaseBall();
		if (stateOfGumballMachine.getCount() == 0) {
			stateOfGumballMachine.setState(stateOfGumballMachine.getSoldOutState());
		} else {
			stateOfGumballMachine.releaseBall();
			System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
			if (stateOfGumballMachine.getCount() > 0) {
				stateOfGumballMachine.setState(stateOfGumballMachine.getNoQuarterState());
			} else {
				System.out.println("Oops, out of gumballs!");
				stateOfGumballMachine.setState(stateOfGumballMachine.getSoldOutState());
			}
		}
	}

	@Override
	public void refill() { }

	@Override
	public String toString() {
		return "dispensing two gumballs for your quarter, because YOU'RE A WINNER!";
	}
}
