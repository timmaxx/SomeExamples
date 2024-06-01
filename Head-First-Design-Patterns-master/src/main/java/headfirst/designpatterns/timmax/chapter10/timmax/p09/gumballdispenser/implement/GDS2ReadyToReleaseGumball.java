package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class GDS2ReadyToReleaseGumball extends AGumballDispenserState {
    public GDS2ReadyToReleaseGumball(GumballDispenserStateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(GDS1GumballBoxIsEmpty.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(GDS2ReadyToReleaseGumball.class, true)
        );
    }

    @Override
    public void refillGumballBox() {
        super.refillGumballBox();
        getStateContext()._refillGumballBox();
    }

    @Override
    public void releaseGumball() {
        super.releaseGumball();
        getStateContext()._releaseGumball();
    }
}
