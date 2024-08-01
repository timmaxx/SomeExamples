package headfirst.designpatterns.timmax.chapter10.p06.inners;

public class SPNoQuarter extends AStateProtected {
	public SPNoQuarter(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	// Implemented methods of interface IStateProtected:
	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	}

	@Override
	public void refill() { }

	// Implemented methods of interface IState:
	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		stateOfGumballMachine.getISPHasQuarter().setAsCurrent();
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	}

	// Overridden methods of class Object:
	@Override
	public String toString() {
		return "waiting for quarter";
	}
}
