package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class SPWinner extends SPSoldBase {
    public SPWinner(StateContext stateContext) {
        super(stateContext);
    }

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        super.doOnEnter();

        if (getNumberGumballs() == 0) {
            return;
        }
        releaseBall();
        System.out.println("You're a winner! You got two gumballs for your quarter");
        if (getNumberGumballs() > 0) {
            changeState(getStateContext().getSpNoQuarter());
        } else {
            changeState(getStateContext().getSpSoldOut());
        }
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "dispensing two gumballs for your quarter, because you're a winner!";
    }
}
