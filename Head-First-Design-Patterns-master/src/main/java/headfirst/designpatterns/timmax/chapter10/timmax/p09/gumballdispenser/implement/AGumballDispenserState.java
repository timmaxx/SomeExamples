package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.IStateOfGumballDispenser;

public abstract class AGumballDispenserState extends AState implements IStateOfGumballDispenser {
    public AGumballDispenserState(StateContext stateContext) {
        super(stateContext);
    }

    @Override
    public void doOnEnter() {
        System.out.println("Gumball dispenser has entered into state '" + this + "'");
    }

    @Override
    public GumballDispenserStateContext getStateContext() {
        return (GumballDispenserStateContext) super.getStateContext();
    }
}
