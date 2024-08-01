package headfirst.designpatterns.timmax.chapter10.timmax.p08.common.state;

import java.util.HashSet;
import java.util.Set;

import headfirst.designpatterns.timmax.chapter10.timmax.p08.common.classes.Classes;

public abstract class AState<StateData> implements IStateContext<StateData> {
    private final StateContext<StateData> stateContext;
    private final Class<StateData> stateDataClass;

    protected final Set<PairDestStateAndCanSwitchWithoutParams> setOfPairDestStateAndCanSwitchWithoutParams;

    protected StateData stateData;

    public AState(StateContext<StateData> stateContext, Class<StateData> stateDataClass) {
        this.stateContext = stateContext;
        this.stateDataClass = stateDataClass;
        this.setOfPairDestStateAndCanSwitchWithoutParams = new HashSet<>();
    }

    public StateContext<StateData> getStateContext() {
        return stateContext;
    }

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

    @Override
    public final StateData getData() {
        return stateData;
    }

    @Override
    public void setData(StateData stateData) {
        if (stateData == null) {
            throw new RuntimeException("Data for state '" + this + "' is null!");
        }
        if (!Classes.isInstanceOf(stateData, stateDataClass)) {
            throw new RuntimeException("Data for state '" + this + "' is wrong type!");
        }
        this.stateData = stateData;
    }

    // Implemented methods of interface IStateContext
    @Override
    public final void changeState(AState<StateData> aState) {
        checkPosibleToChangeState(aState, false);
        aState.setAsCurrent();
    }

    @Override
    public final void changeState(AState<StateData> aState, StateData stateData) {
        checkPosibleToChangeState(aState, true);
        aState.setData(stateData);
        aState.setAsCurrent();
    }
}
