package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import javax.lang.model.type.NullType;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public abstract class SPGivingGumABase extends AGumballMachineState<NullType> {
    public SPGivingGumABase(StateContext stateContext) {
        super(stateContext, null);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPNoQuarter.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPSoldOut.class, true)
        );
    }

    protected void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (getNumberGumballs() > 0) {
            getStateContext().getSpNoQuarter().setData((getNumberGumballs() - 1));
        }
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball!");
    }

    @Override
    public void refill() {
    }

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        super.doOnEnter();

        getStateContext().incCountOfQuarters();
        releaseBall();
        if (getNumberGumballs() == 0) {
            changeState(getStateContext().getSpSoldOut());
        }
    }
}
