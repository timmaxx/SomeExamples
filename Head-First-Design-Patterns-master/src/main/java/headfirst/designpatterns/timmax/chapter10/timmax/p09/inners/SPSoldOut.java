package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

import static headfirst.designpatterns.timmax.chapter10.timmax.p09.inners.GumballMachineStateContext.MAX_OF_GUMBALLS;

public class SPSoldOut extends AGumballMachineState {
    public SPSoldOut(StateContext stateContext) {
        super(stateContext);
		// Такой вариант не описан на стр. 442, но должен быть...
		setOfPairDestStateAndCanSwitchWithoutParams.add(
				new PairDestStateAndCanSwitchWithoutParams(SPNoQuarter.class, true)
		);
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void refill() {
        getStateContext().setCountOfGumballs(MAX_OF_GUMBALLS);
        changeState(getStateContext().getSpNoQuarter());
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "sold out";
    }
}
