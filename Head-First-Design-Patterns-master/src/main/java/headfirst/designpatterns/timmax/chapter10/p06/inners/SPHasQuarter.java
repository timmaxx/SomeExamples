package headfirst.designpatterns.timmax.chapter10.p06.inners;

import java.util.Random;

public class SPHasQuarter extends AStateProtected {
	private final Random randomWinner = new Random(System.currentTimeMillis());

	public SPHasQuarter(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	// Implemented methods of interface IStateProtected:
	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	@Override
	public void refill() { }

	// Implemented methods of interface IState:
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Quarter returned");
		stateOfGumballMachine.getIStateProtectedNoQuarter().setAsCurrent();
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned...");
		int winner = randomWinner.nextInt(10);
		if ((winner == 0) && (stateOfGumballMachine.getCount() > 1)) {
			stateOfGumballMachine.getISPWinner().setAsCurrent();
		} else {
			stateOfGumballMachine.getISPSold().setAsCurrent();
		}
	}

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return "waiting for turn of crank";
	}
}
