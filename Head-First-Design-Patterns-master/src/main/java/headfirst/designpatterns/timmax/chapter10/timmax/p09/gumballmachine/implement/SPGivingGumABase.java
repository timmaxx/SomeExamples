package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public abstract class SPGivingGumABase extends AGumballMachineState {
    public SPGivingGumABase(StateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(GMS2ReadyToReceiveCoin.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(GMS1SoldOut.class, true)
        );
    }

    protected void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        // getStateContext().decCountOfGumballs();
        getStateContext().getGumballDispenser().releaseGumball();
        /*
        if (getStateContext().getCountOfGumballs() == 0) {
            changeState(getStateContext().getSpSoldOut());
        }
        */
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertCoin() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void refillGumballBox() {
    }

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        System.out.println("You turned...");
        super.doOnEnter();

        if (true) { // если нет места в монетоприемнике
            return;
        }
        if (true) { // если нет гумбола
            return;
        }
        releaseBall();
        // принять монету (Увеличить число монет)
    }
}
