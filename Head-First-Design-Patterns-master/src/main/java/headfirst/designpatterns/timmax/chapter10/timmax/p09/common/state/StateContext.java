package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateContext implements IStateContext {
    private AState<?> currentState;

    public AState<?> getCurrentState() {
        return currentState;
    }

    public <StateData> void setCurrentState(AState<StateData> currentState) {
        this.currentState = currentState;
        currentState.doOnEnter();
    }

    @Override
    public final <TargetStateData> void changeState(AState<TargetStateData> aState) {
        currentState.changeState(aState);
    }

    @Override
    public final <TargetStateData> void changeState(AState<TargetStateData> aState, TargetStateData targetStateData) {
        currentState.changeState(aState, targetStateData);
    }
}
