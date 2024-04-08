package headfirst.designpatterns.timmax.chapter10.timmax.p07.inners;

public class SPSoldOut extends AStateProtected {
	public SPSoldOut(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	// Implemented methods of interface IStateProtected:
	@Override
	public void dispense() {
		System.out.println("No gumball dispensed");
	}

	@Override
	public void refill() {
		stateOfGumballMachine.getIStateProtectedNoQuarter().setAsCurrent();
	}

	// Implemented methods of interface IStateOfGumballMachine:
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

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return "sold out";
	}
}
