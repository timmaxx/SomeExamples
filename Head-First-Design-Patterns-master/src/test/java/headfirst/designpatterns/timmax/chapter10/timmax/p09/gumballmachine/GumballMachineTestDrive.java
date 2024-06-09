package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine;

public class GumballMachineTestDrive {
	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine();
		System.out.println(gumballMachine + "\n");

		gumballMachine.refillGumballBox();
		System.out.println(gumballMachine + "\n");

		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");

		gumballMachine.insertCoin();
		System.out.println(gumballMachine + "\n");

		gumballMachine.ejectCoin();
		System.out.println(gumballMachine + "\n");

		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");

		gumballMachine.insertCoin();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");

		gumballMachine.insertCoin();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");

		gumballMachine.insertCoin();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");

		gumballMachine.insertCoin();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");

		gumballMachine.insertCoin();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");

		gumballMachine.insertCoin();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");

		gumballMachine.insertCoin();
		gumballMachine.turnCrank();
		System.out.println(gumballMachine + "\n");
	}
}
