package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateAutomaton;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.IStateAutomatonOfGumballDispenser;

public class GumballDispenser extends StateAutomaton implements IStateAutomatonOfGumballDispenser {
    public final static int MAX_OF_GUMBALLS = 6;

    private final SGD1GumballBoxIsEmpty sgd1GumballBoxIsEmpty;
    private final SGD2ReadyToReleaseGumball sgd2ReadyToReleaseGumball;

    private int countOfGumballs;

    public GumballDispenser() {
        sgd1GumballBoxIsEmpty = new SGD1GumballBoxIsEmpty(this);
        sgd2ReadyToReleaseGumball = new SGD2ReadyToReleaseGumball(this);

        this.countOfGumballs = 0;
        changeState(sgd1GumballBoxIsEmpty);
    }

    // ----
    void _refillGumballBox() {
        // 1. Проверка, что метод можно вызывать. Если нельзя, то бросить исключение.

        // 2. Действие перед переходом в другое состояние.
        System.out.println("GD. Before refilling the gumball box there are " + countOfGumballs + " gumballs in the gumball box.");
        countOfGumballs = MAX_OF_GUMBALLS;
        System.out.println("GD. After refilling the gumball box there are " + countOfGumballs + " gumballs in the gumball box.");

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        changeState(sgd2ReadyToReleaseGumball);
    }

    void _releaseGumball() {
        // 1. Проверка, что метод можно вызывать. Если нельзя, то бросить исключение.
        if (countOfGumballs <= 0) {
            throw new RuntimeException("GD. The gumball box is empty, but it doesn't have to be.");
        }

        // 2. Действие перед переходом в другое состояние.
        countOfGumballs--;
        System.out.println("GD. A gumball has rolled out.");

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        if (countOfGumballs <= 0) {
            changeState(sgd1GumballBoxIsEmpty);
            return;
        }
        changeState(sgd2ReadyToReleaseGumball);
    }

    // interface IStateAutomatonOfGumballDispenser
    @Override
    public final int getCountOfGumballs() {
        return countOfGumballs;
    }

    // class StateAutomaton
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
