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

    public StateContext getStateContext() {
        return stateContext;
    }

    public abstract void doOnEnter();

    private void setAsCurrent() {
        stateContext.setCurrentState(this);
    }

    private void checkPosibleToChangeState(AState aState) {
        for (PairDestStateAndCanSwitchWithoutParams pairDestStateAndCanSwitchWithoutParams : setOfPairDestStateAndCanSwitchWithoutParams) {
            if (Classes.isInstanceOf(aState, pairDestStateAndCanSwitchWithoutParams.destinationStateClass())
                    && pairDestStateAndCanSwitchWithoutParams.canSwitchWithoutParams()) {
                return;
            }
        }
        throw new RuntimeException("You cannot change state from '" + this + "' to '" + aState + "'!");
    }

    // Implemented methods of interface IStateContext
    @Override
    public void changeState(AState<?> aState) {
        // Warning:(63, 35) Unchecked cast: 'headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState<capture<?>>' to 'headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState<StateData>'
        checkPosibleToChangeState(aState);
        aState.setAsCurrent();
    }
}
