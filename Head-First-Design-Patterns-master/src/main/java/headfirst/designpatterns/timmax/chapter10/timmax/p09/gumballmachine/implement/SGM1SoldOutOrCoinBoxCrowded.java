package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

public class SGM1SoldOutOrCoinBoxCrowded extends AStateOfGumballMachine {
    public SGM1SoldOutOrCoinBoxCrowded(GumballMachine gumballMachine) {
        super(gumballMachine);
		// Такой вариант не описан на стр. 442, но должен быть...
		setOfDestState.add(SGM2ReadyToReceiveCoinAndDispenseGumball.class);
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertCoin() {
        super.insertCoin();
        System.out.println("GM. You can't insert a coin, the machine is sold out.");
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        System.out.println("GM. You can't eject, you haven't inserted a coin yet.");
    }

    @Override
    public void turnCrank() {
        super.turnCrank();
        System.out.println("GM. You turned, but there are no gumballs");
    }

    @Override
    public void refillGumballBox() {
        super.refillGumballBox();
        getStateAutomaton()._refillGumballBox();
    }

    @Override
    public void pullOutAllCoins() {
        super.pullOutAllCoins();
        getStateAutomaton()._pullOutAllCoins();
    }

/*
    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "sold out";
    }
*/
}
