package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class GDS1GumballBoxIsEmpty extends AGumballDispenserState {
    public GDS1GumballBoxIsEmpty(StateContext stateContext) {
        super(stateContext);
    }

    @Override
    public void refillGumballBox() {

    }

    @Override
    public void releaseGumball() {
        // Исключение
    }
}
