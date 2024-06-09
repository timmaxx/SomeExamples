package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.IStateOfGumballDispenser;

public abstract class AStateOfGumballDispenser extends AState implements IStateOfGumballDispenser {
    public AStateOfGumballDispenser(GumballDispenser gumballDispenser) {
        super(gumballDispenser);
    }

    // class AState
    @Override
    public void doOnEnter() {
        System.out.println("Gumball dispenser has entered into state '" + this + "'");
    }

    @Override
    public GumballDispenser getStateAutomaton() {
        return (GumballDispenser) super.getStateAutomaton();
    }

    // interface IStateOfGumballDispenser
    @Override
    public void refillGumballBox() {
        System.out.println("GD. You are trying to refill the gumball box.");
    }

    @Override
    public void releaseGumball() {
        System.out.println("GD. You are trying to release a gumball.");
    }
}
