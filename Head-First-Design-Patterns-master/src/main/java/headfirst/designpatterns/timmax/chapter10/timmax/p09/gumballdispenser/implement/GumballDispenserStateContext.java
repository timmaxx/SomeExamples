package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.IStateOfGumballDispenser;

public class GumballDispenserStateContext extends StateContext implements IStateOfGumballDispenser {
    public final static int MAX_OF_GUMBALLS = 6;

    private final GDS1GumballBoxIsEmpty gds1GumballBoxIsEmpty;
    private final GDS2ReadyToReleaseGumball gds2ReadyToReleaseGumball;

    private int countOfGumballs;

    public GumballDispenserStateContext() {
        gds1GumballBoxIsEmpty = new GDS1GumballBoxIsEmpty(this);
        gds2ReadyToReleaseGumball = new GDS2ReadyToReleaseGumball(this);

        this.countOfGumballs = 0;
        setCurrentState(gds1GumballBoxIsEmpty);
    }

    public int getCountOfGumballs() {
        return countOfGumballs;
    }

    public GDS1GumballBoxIsEmpty getGds1GumballBoxIsEmpty() {
        return gds1GumballBoxIsEmpty;
    }

    public GDS2ReadyToReleaseGumball getGds2ReadyToReleaseGumball() {
        return gds2ReadyToReleaseGumball;
    }

    void _refillGumballBox() {
        System.out.println("Before refilling the gumball box there are " + countOfGumballs + " gumballs in the gumball box.");
        countOfGumballs = MAX_OF_GUMBALLS;
        getCurrentState().changeState(getGds2ReadyToReleaseGumball());
        System.out.println("After refilling the gumball box there are " + countOfGumballs + " gumballs in the gumball box.");
    }

    public void _releaseGumball() {
        if (countOfGumballs <= 0) {
            throw new RuntimeException("");
        }
        countOfGumballs--;
        if (countOfGumballs <= 0) {
            getCurrentState().changeState(getGds1GumballBoxIsEmpty());
            return;
        }
        getCurrentState().changeState(getGds2ReadyToReleaseGumball());
    }

    @Override
    public AGumballDispenserState getCurrentState() {
        return (AGumballDispenserState) super.getCurrentState();
    }

    @Override
    public void refillGumballBox() {
        getCurrentState().refillGumballBox();
    }

    @Override
    public void releaseGumball() {
        getCurrentState().releaseGumball();
    }

    @Override
    public String toString() {
        return getCurrentState().toString() + ". MAX_OF_GUMBALLS = " + MAX_OF_GUMBALLS + ". countOfGumballs = " + countOfGumballs;
    }
}
