package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class SGD2ReadyToReleaseGumball extends AStateOfGumballDispenser {
    public SGD2ReadyToReleaseGumball(StateContextOfGumballDispenser stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SGD1GumballBoxIsEmpty.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SGD2ReadyToReleaseGumball.class, true)
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
