package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

import java.util.Random;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.CRS1ReadyToReceiveCoin;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class GMSCoinReceived extends AGumballMachineState {
    private final Random randomWinner = new Random(System.currentTimeMillis());

    public GMSCoinReceived(StateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(GMSEjectingCoin.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPGivingGumOne.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPGivingGumWinner.class, true)
        );
    }

    // Implemented methods of the IStateOfGumballMachine interface:
    @Override
    public void insertCoin() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectCoin() {
        getStateContext().getCoinReceiver().ejectCoin();
        if (getStateContext().getCoinReceiver().getCurrentState() instanceof CRS1ReadyToReceiveCoin) {
            changeState(getStateContext().getGmsEjectingCoin());
        }
    }

    @Override
    public void turnCrank() {
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (getStateContext().getGumballDispenser().getCountOfGumballs() > 1)) {
            changeState(getStateContext().getSpGivingGumWinner());
        } else {
            changeState(getStateContext().getSpGivingGumOne());
        }
    }

    @Override
    public void refillGumballBox() {
        System.out.println("Not for this state");
    }

    @Override
    public void pullOutAllCoins() {
        System.out.println("Not for this state");
    }

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        System.out.println("You inserted a quarter");
        super.doOnEnter();
    }

    // Overridden methods of the Object class:
    @Override
    public String toString() {
        return "waiting for turn of crank";
    }
}
