package headfirst.designpatterns.timmax.chapter10.timmax.p08.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p08.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p08.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p08.common.state.StateContext;

public class SPNoQuarter extends AGumballMachineState implements IStateOfGumballMachine, IStateOfGumballMachineProtected {
    public SPNoQuarter(StateContext stateContext) {
        super(stateContext, Integer.class);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPHasQuarter.class, true)
        );
    }

    public void setNumberGumballs(int numberGumballs) {
        setData(numberGumballs);
    }

    // Implemented methods of interface IStateOfGumballMachineProtected:
    @Override
    public void dispense() {
        System.out.println("You need to pay first");
    }

    @Override
    public void refill() {
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertQuarter() {
        System.out.println("You inserted a quarter");
        changeState(getStateContext().getSpHasQuarter());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there's no quarter");
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "waiting for quarter";
    }
}
