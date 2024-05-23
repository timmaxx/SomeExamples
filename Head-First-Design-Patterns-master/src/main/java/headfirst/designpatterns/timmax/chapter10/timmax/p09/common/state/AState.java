package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

import java.util.HashSet;
import java.util.Set;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.classes.Classes;

public abstract class AState<StateData> implements IState<StateData> {
    private final StateContext stateContext;
    private final Class<StateData> stateDataClass;

    protected final Set<PairDestStateAndCanSwitchWithoutParams> setOfPairDestStateAndCanSwitchWithoutParams;

    protected StateData stateData;

    public AState(StateContext stateContext, Class<StateData> stateDataClass) {
        this.stateContext = stateContext;
        this.stateDataClass = stateDataClass;
        this.setOfPairDestStateAndCanSwitchWithoutParams = new HashSet<>();
    }

    public StateContext getStateContext() {
        return stateContext;
    }

    public abstract void doOnEnter();

    private void setAsCurrent() {
        stateContext.setCurrentState(this);
    }

    private void checkPosibleToChangeState(AState<StateData> aState, boolean isThereStateData) {
        for (PairDestStateAndCanSwitchWithoutParams pairDestStateAndCanSwitchWithoutParams : setOfPairDestStateAndCanSwitchWithoutParams) {
            if (Classes.isInstanceOf(aState, pairDestStateAndCanSwitchWithoutParams.destinationStateClass())
                    && !isThereStateData
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
        checkPosibleToChangeState((AState<StateData>) aState, false);
        aState.setAsCurrent();
    }
}
