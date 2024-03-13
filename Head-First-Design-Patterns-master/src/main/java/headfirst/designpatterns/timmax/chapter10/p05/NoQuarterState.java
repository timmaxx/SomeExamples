package headfirst.designpatterns.timmax.chapter10.p05;

public class NoQuarterState extends AState {
	public NoQuarterState(StateOfGumballMachine stateOfGumballMachine) {
		super(stateOfGumballMachine);
	}

	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		stateOfGumballMachine.setState(stateOfGumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	}

	@Override
	public void dispense() {
		System.out.println("You need to pay first");
	}

	@Override
	public void refill() { }

	@Override
	public String toString() {
		return "waiting for quarter";
	}
}
