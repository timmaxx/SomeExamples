package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.AStateOfGumballDispenser;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.StateContextOfGumballDispenser;

public class GumballDispenser implements IStateOfGumballDispenser, IStateContextOfGumballDispenser {
    private final StateContextOfGumballDispenser stateContextOfGumballDispenser;

    public GumballDispenser() {
        stateContextOfGumballDispenser = new StateContextOfGumballDispenser();
    }

    // interface IStateContextOfCoinReceiver extends IStateContext
    @Override
    public AStateOfGumballDispenser getCurrentState() {
        return stateContextOfGumballDispenser.getCurrentState();
    }

    // interface IStateContextOfGumballDispenser
    @Override
    public int getCountOfGumballs() {
        return stateContextOfGumballDispenser.getCountOfGumballs();
    }

    // interface IStateOfGumballDispenser
    @Override
    public void refillGumballBox() {
        stateContextOfGumballDispenser.refillGumballBox();
    }

    @Override
    public void releaseGumball() {
        stateContextOfGumballDispenser.releaseGumball();
    }

    // class Object
    @Override
    public String toString() {
        return stateContextOfGumballDispenser.toString();
    }
}
