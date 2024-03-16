package headfirst.designpatterns.timmax.chapter10.p06.inners;

public class SPWinner extends AStateProtected {
	public SPWinner(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	// Implemented methods of interface IStateProtected:
	@Override
	public void dispense() {
		stateOfGumballMachine.releaseBall();
		if (stateOfGumballMachine.getCount() == 0) {
			stateOfGumballMachine.getISPSoldOut().setAsCurrent();
		} else {
			stateOfGumballMachine.releaseBall();
			System.out.println("YOU'RE A WINNER! You got two gumballs for your quarter");
			if (stateOfGumballMachine.getCount() > 0) {
				stateOfGumballMachine.getIStateProtectedNoQuarter().setAsCurrent();
			} else {
				System.out.println("Oops, out of gumballs!");
				stateOfGumballMachine.getISPSoldOut().setAsCurrent();
			}
		}
	}

	@Override
	public void refill() { }

	// Implemented methods of interface IState:
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

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return "dispensing two gumballs for your quarter, because YOU'RE A WINNER!";
	}
}
