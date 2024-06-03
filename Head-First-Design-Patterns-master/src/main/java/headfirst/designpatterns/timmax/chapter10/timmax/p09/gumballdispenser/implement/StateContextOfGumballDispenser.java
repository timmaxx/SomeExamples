package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.IStateContextOfGumballDispenser;

public class StateContextOfGumballDispenser extends StateContext implements IStateContextOfGumballDispenser {
    public final static int MAX_OF_GUMBALLS = 6;

    private final SGD1GumballBoxIsEmpty sgd1GumballBoxIsEmpty;
    private final SGD2ReadyToReleaseGumball sgd2ReadyToReleaseGumball;

    private int countOfGumballs;

    public StateContextOfGumballDispenser() {
        sgd1GumballBoxIsEmpty = new SGD1GumballBoxIsEmpty(this);
        sgd2ReadyToReleaseGumball = new SGD2ReadyToReleaseGumball(this);

        this.countOfGumballs = 0;
        changeState(sgd1GumballBoxIsEmpty);
    }

    // ----
    void _refillGumballBox() {
        System.out.println("Before refilling the gumball box there are " + countOfGumballs + " gumballs in the gumball box.");
        countOfGumballs = MAX_OF_GUMBALLS;
        changeState(sgd2ReadyToReleaseGumball);
        System.out.println("After refilling the gumball box there are " + countOfGumballs + " gumballs in the gumball box.");
    }

    void _releaseGumball() {
        if (countOfGumballs <= 0) {
            throw new RuntimeException("The gumball box is empty, but it doesn't have to be.");
        }
        countOfGumballs--;
        if (countOfGumballs <= 0) {
            changeState(sgd1GumballBoxIsEmpty);
            return;
        }
        changeState(sgd2ReadyToReleaseGumball);
    }

    // interface IStateContextOfGumballDispenser
    @Override
    public final int getCountOfGumballs() {
        return countOfGumballs;
    }

    // class StateContext
    @Override
    public AStateOfGumballDispenser getCurrentState() {
        return (AStateOfGumballDispenser) super.getCurrentState();
    }

    // interface IStateOfGumballDispenser
    @Override
    public void refillGumballBox() {
        getCurrentState().refillGumballBox();
    }

    @Override
    public void releaseGumball() {
        getCurrentState().releaseGumball();
    }

    // class Object
    @Override
    public String toString() {
        return getCurrentState().toString() + ". MAX_OF_GUMBALLS = " + MAX_OF_GUMBALLS + ". countOfGumballs = " + countOfGumballs;
    }
}
