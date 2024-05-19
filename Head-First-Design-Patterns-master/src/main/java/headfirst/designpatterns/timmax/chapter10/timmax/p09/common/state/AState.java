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
    public void changeState(AState<?> aState) {
        // Warning:(61, 35) Unchecked cast: 'headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState<capture<?>>' to 'headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState<StateData>'
        checkPosibleToChangeState((AState<StateData>) aState, false);
        aState.setAsCurrent();
    }

    @Override
    public final <TargetStateData> void changeState(AState<TargetStateData> aState, TargetStateData stateData) {
        // Warning:(68, 35) Unchecked cast: 'headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState<TargetStateData>' to 'headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState<StateData>'
        checkPosibleToChangeState((AState<StateData>) aState, true);
        aState.setData(stateData);
        aState.setAsCurrent();
    }

    public void doOnEnter() {
        System.out.println("Machine has entered into state '" + this + "'");
    }
}
