package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.IStateOfGumballDispenser;

public abstract class AGumballDispenserState extends AState implements IStateOfGumballDispenser {
    public AGumballDispenserState(GumballDispenserStateContext stateContext) {
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

    @Override
    public void refillGumballBox() {
        System.out.println("You are trying to refill the gumball box.");
    }

    @Override
    public void releaseGumball() {
        System.out.println("You are trying to release a gumball.");
    }
}
