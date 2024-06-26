package headfirst.designpatterns.timmax.chapter10.timmax.p07.common.state;

import java.util.HashSet;
import java.util.Set;

import headfirst.designpatterns.timmax.chapter10.timmax.p07.common.classes.Classes;

public abstract class AState implements IStateContext {
    private final StateContext stateContext;
    private final Class<? extends StateData> stateDataClass;

    protected final Set<PairDestStateAndCanSwitchWithoutParams> setOfPairDestStateAndCanSwitchWithoutParams;

    protected StateData stateData;

    public AState(StateContext stateContext, Class<? extends StateData> stateDataClass) {
        this.stateContext = stateContext;
        this.stateDataClass = stateDataClass;
        this.setOfPairDestStateAndCanSwitchWithoutParams = new HashSet<>();
    }

    private void checkPosibleToChangeState(AState aState, boolean isThereStateData) {
        for (PairDestStateAndCanSwitchWithoutParams pairDestStateAndCanSwitchWithoutParams : setOfPairDestStateAndCanSwitchWithoutParams) {
            if (Classes.isInstanceOf(aState, pairDestStateAndCanSwitchWithoutParams.destinationStateClass())
                    && !isThereStateData
                    && pairDestStateAndCanSwitchWithoutParams.canSwitchWithoutParams()) {
                return;
            }
        }
        throw new RuntimeException("You cannot change state from '" + this + "' to '" + aState + "'!");
    }

    private void setData(StateData stateData) {
        if (stateData == null) {
            throw new RuntimeException("Data for state '" + this + "' is null!");
        }
        if (!Classes.isInstanceOf(stateData, stateDataClass)) {
            throw new RuntimeException("Data for state '" + this + "' is wrong type!");
        }
        this.stateData = stateData;
    }

    private void setAsCurrent() {
        stateContext.currentState = this;
    }

    // Implemented methods of interface IStateContext
    @Override
    public final void changeState(AState aState) {
        checkPosibleToChangeState(aState, false);
        aState.setAsCurrent();
    }

    @Override
    public final void changeState(AState aState, StateData stateData) {
        checkPosibleToChangeState(aState, true);
        aState.setData(stateData);
        aState.setAsCurrent();
    }

    @Override
    public final StateData getData() {
        return stateData;
    }
}
