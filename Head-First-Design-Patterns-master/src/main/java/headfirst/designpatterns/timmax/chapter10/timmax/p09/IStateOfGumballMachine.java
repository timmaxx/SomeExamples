package headfirst.designpatterns.timmax.chapter10.timmax.p09;

public interface IStateOfGumballMachine {
	void insertQuarter();
	void ejectQuarter();
	void turnCrank();
	// ToDo: поскольку монеты копятся, то нужно делать их выемку с распечаткой отчёта.
	//       Но выемка должна быть доступна только инкассаторам...
}
