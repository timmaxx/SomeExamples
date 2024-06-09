package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class SGM2ReadyToReceiveCoinAndDispenseGumball extends AStateOfGumballMachine implements IStateOfGumballMachine {
    public SGM2ReadyToReceiveCoinAndDispenseGumball(StateContextOfGumballMachine stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SGM3CoinReceivedIntermediately.class, true)
        );
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertCoin() {
        super.insertCoin();
        getStateContext()._insertCoin();
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        System.out.println("GM. You haven't inserted a coin.");
    }

    @Override
    public void turnCrank() {
        super.turnCrank();
        System.out.println("GM. You turned, but there's no coin.");
    }

    @Override
    public void refillGumballBox() {
        super.refillGumballBox();
        getStateContext()._refillGumballBox();
    }

    @Override
    public void pullOutAllCoins() {
        super.pullOutAllCoins();
        getStateContext()._pullOutAllCoins();
    }
/*
    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "waiting for quarter";
    }
*/
}
