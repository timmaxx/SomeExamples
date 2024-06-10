package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

public class SGM3CoinReceivedIntermediately extends AStateOfGumballMachine {
    // private final Random randomWinner = new Random(System.currentTimeMillis());

    public SGM3CoinReceivedIntermediately(GumballMachine gumballMachine) {
        super(gumballMachine);
        setOfDestState.add(SGM1SoldOutOrCoinBoxCrowded.class);
        setOfDestState.add(SGM2ReadyToReceiveCoinAndDispenseGumball.class);
    }

    // Implemented methods of the IStateOfGumballMachine interface:
    @Override
    public void insertCoin() {
        super.insertCoin();
        System.out.println("GM. You can't insert another quarter");
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        getStateAutomaton()._ejectCoin();
    }

    @Override
    public void turnCrank() {
        super.turnCrank();
        getStateAutomaton()._turnCrank();
/*
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (this.getStateContext().getGumballDispenser().getCountOfGumballs() > 1)) {
            //changeState(getStateContext().getSpGivingGumWinner());
        } else {
            //changeState(getStateContext().getSpGivingGumOne());
        }
*/
    }

    @Override
    public void refillGumballBox() {
        super.refillGumballBox();
        System.out.println("GM. Not for this state.");
    }

    @Override
    public void pullOutAllCoins() {
        super.pullOutAllCoins();
        System.out.println("GM. Not for this state.");
    }
/*
    // Overridden methods of the Object class:
    @Override
    public String toString() {
        return "waiting for turn of crank";
    }
*/
}
