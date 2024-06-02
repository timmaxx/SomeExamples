package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

import java.util.HashSet;
import java.util.Set;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.classes.Classes;

public abstract class AState implements IState {
    private final StateContext stateContext;

    protected final Set<PairDestStateAndCanSwitchWithoutParams> setOfPairDestStateAndCanSwitchWithoutParams;

    public AState(StateContext stateContext) {
        this.stateContext = stateContext;
        this.setOfPairDestStateAndCanSwitchWithoutParams = new HashSet<>();
    }

    private void checkPosibleToChangeState(IState state) {
        for (PairDestStateAndCanSwitchWithoutParams pairDestStateAndCanSwitchWithoutParams : setOfPairDestStateAndCanSwitchWithoutParams) {
            if (Classes.isInstanceOf(state, pairDestStateAndCanSwitchWithoutParams.destinationStateClass())
                    && pairDestStateAndCanSwitchWithoutParams.canSwitchWithoutParams()) {
                return;
            }
        }
        throw new RuntimeException("You cannot change state from '" + this + "' to '" + state + "'!");
    }

    // Implemented methods of interface IState
    @Override
    public StateContext getStateContext() {
        return stateContext;
    }

    @Override
    public final void changeState(IState state) {
        checkPosibleToChangeState(state);
        stateContext.changeState(state);
    }

    @Override
    public void doOnEnter() {
    }

    @Override
    public void doOnExit() {
    }

    // class Object
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
