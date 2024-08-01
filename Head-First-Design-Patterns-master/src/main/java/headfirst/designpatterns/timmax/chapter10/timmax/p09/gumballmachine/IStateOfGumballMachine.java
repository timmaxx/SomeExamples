package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine;

public interface IStateOfGumballMachine {
	void insertCoin();
	void ejectCoin();
	void turnCrank();

	// ToDo: поскольку монеты копятся, то нужно делать их выемку с распечаткой отчёта.
	//       Но выемка должна быть доступна только инкассаторам...
	// 1. выемка денег

	// 2. выемка остатков гумболов.

	// 3. заправка гумболами.
	// ToDo: refill() сделать разный (нужно ввести ёмкость бака для гумболов):
	//       1. дополнить на N гумболов (если дополнение превышает ёмкость бака, как-то обрабатывать).
	//       2. дополнить "до горлышка".
	void refillGumballBox();

	void pullOutAllCoins();
}
