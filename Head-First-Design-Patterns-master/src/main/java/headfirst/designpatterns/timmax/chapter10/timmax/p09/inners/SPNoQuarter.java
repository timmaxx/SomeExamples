package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class SPNoQuarter extends AGumballMachineState {
    public static int MAX_OF_GUMBALLS = 6;
    private int numberGumballs;

    public SPNoQuarter(StateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPHasQuarter.class, true)
        );
        numberGumballs = 0;
    }

    public int getNumberGumballs() {
        return numberGumballs;
    }

    public void setNumberGumballs(int numberGumballs) {
        this.numberGumballs = numberGumballs;
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertQuarter() {
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

    @Override
    public void refill() {
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "waiting for quarter";
    }
}
