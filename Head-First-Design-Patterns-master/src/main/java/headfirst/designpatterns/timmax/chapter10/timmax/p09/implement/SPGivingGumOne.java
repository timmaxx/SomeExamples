package headfirst.designpatterns.timmax.chapter10.timmax.p09.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class SPGivingGumOne extends SPGivingGumABase {
    public SPGivingGumOne(StateContext stateContext) {
        super(stateContext);
    }

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        super.doOnEnter();

        if (getStateContext().getCountOfGumballs() > 0) {
            changeState(getStateContext().getSpNoQuarter());
        }
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "dispensing a gumball";
    }
}
