package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.AGumballDispenserState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.GumballDispenserStateContext;

public class GumballDispenser implements IStateOfGumballDispenser {
    private final GumballDispenserStateContext gumballDispenserStateContext;

    public GumballDispenser() {
        gumballDispenserStateContext = new GumballDispenserStateContext();
    }

    public AGumballDispenserState getCurrentState() {
        return gumballDispenserStateContext.getCurrentState();
    }

    public int getCountOfGumballs() {
        return gumballDispenserStateContext.getCountOfGumballs();
    }

    @Override
    public void refillGumballBox() {
        gumballDispenserStateContext.refillGumballBox();
    }

    @Override
    public void releaseGumball() {
        gumballDispenserStateContext.releaseGumball();
    }

    @Override
    public String toString() {
        return gumballDispenserStateContext.toString();
    }
}
