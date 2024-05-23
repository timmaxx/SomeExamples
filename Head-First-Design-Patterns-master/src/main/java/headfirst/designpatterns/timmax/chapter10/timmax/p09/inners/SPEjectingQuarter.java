package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import javax.lang.model.type.NullType;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class SPEjectingQuarter extends AGumballMachineState<NullType> {
    public SPEjectingQuarter(StateContext stateContext) {
        super(stateContext);
		// Такой вариант не описан на стр. 442, но должен быть...
		setOfPairDestStateAndCanSwitchWithoutParams.add(
				new PairDestStateAndCanSwitchWithoutParams(SPNoQuarter.class, true)
		);
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is ejecting quarter");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Please wait! Your quarter is ejecting");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please wait! Your quarter is ejecting");
    }

    @Override
    public void refill() {
    }

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        super.doOnEnter();
        System.out.println("Quarter returned");
        changeState(getStateContext().getSpNoQuarter());
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "ejecting quarter";
    }
}
