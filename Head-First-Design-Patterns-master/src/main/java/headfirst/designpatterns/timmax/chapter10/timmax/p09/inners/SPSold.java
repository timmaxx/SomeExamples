package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import javax.lang.model.type.NullType;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class SPSold extends AGumballMachineState<NullType> implements IStateOfGumballMachineProtected {
    public SPSold(StateContext stateContext) {
        super(stateContext, null);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPNoQuarter.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPSoldOut.class, true)
        );
    }

    // Implemented methods of interface IStateOfGumballMachineProtected:
    @Override
    public void refill() {
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

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        super.doOnEnter();

        getStateContext().releaseBall();
        if (getNumberGumballs() > 0) {
            changeState(getStateContext().getSpNoQuarter());
        } else {
            changeState(getStateContext().getSpSoldOut());
        }
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "dispensing a gumball";
    }
}
