package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class GDS2ReadyToReleaseGumball extends AGumballDispenserState {
    public GDS2ReadyToReleaseGumball(StateContext stateContext) {
        super(stateContext);
    }

    @Override
    public void refillGumballBox() {
        // Исключение
    }

    @Override
    public void releaseGumball() {

    }
}
