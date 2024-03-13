package headfirst.designpatterns.timmax.chapter10.p06;

import java.util.Random;

public class HasQuarterState extends AState {
	Random randomWinner = new Random(System.currentTimeMillis());

	public HasQuarterState(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		stateOfGumballMachine.setState(stateOfGumballMachine.getNoQuarterState());
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (stateOfGumballMachine.getCount() > 1)) {
			stateOfGumballMachine.setState(stateOfGumballMachine.getWinnerState());
		} else {
			stateOfGumballMachine.setState(stateOfGumballMachine.getSoldState());
		}
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	@Override
	public void refill() { }

	@Override
	public String toString() {
		return "waiting for turn of crank";
	}
}
