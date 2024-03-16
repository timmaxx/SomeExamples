package headfirst.designpatterns.timmax.chapter10.p06.inners;

public class SPSold extends AStateProtected {
	public SPSold(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	// Implemented methods of interface IStateProtected:
	@Override
	public void dispense() {
		stateOfGumballMachine.releaseBall();
		if (stateOfGumballMachine.getCount() > 0) {
			stateOfGumballMachine.getIStateProtectedNoQuarter().setAsCurrent();
		} else {
			System.out.println("Oops, out of gumballs!");
			stateOfGumballMachine.getISPSoldOut().setAsCurrent();
		}
	}

	@Override
	public void refill() { }

	// Implemented methods of interface IState:
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

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return "dispensing a gumball";
	}
}
