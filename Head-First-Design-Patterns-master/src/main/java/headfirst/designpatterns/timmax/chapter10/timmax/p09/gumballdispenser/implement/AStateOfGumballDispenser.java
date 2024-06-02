package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.IStateOfGumballDispenser;

public abstract class AStateOfGumballDispenser extends AState implements IStateOfGumballDispenser {
    public AStateOfGumballDispenser(StateContextOfGumballDispenser stateContext) {
        super(stateContext);
    }

    // class AState
    @Override
    public void doOnEnter() {
        System.out.println("Gumball dispenser has entered into state '" + this + "'");
    }

    @Override
    public StateContextOfGumballDispenser getStateContext() {
        return (StateContextOfGumballDispenser) super.getStateContext();
    }

    // interface IStateOfGumballDispenser
    @Override
    public void refillGumballBox() {
        System.out.println("You are trying to refill the gumball box.");
    }

    @Override
    public void releaseGumball() {
        System.out.println("You are trying to release a gumball.");
    }
}
