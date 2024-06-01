package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class GDS2ReadyToReleaseGumball extends AGumballDispenserState {
    public GDS2ReadyToReleaseGumball(GumballDispenserStateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(GDS1GumballBoxIsEmpty.class, true)
        );
    }

    @Override
    public void refillGumballBox() {
        // Исключение
    }

    @Override
    public void releaseGumball() {

    }
}
