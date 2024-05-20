package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateContext implements IStateContext {
    private AState<?> currentState;

    protected AState<?> getCurrentState() {
        return currentState;
    }

    protected <StateData> void setCurrentState(AState<StateData> currentState) {
        this.currentState = currentState;
        currentState.doOnEnter();
    }

    @Override
    public final <TargetStateData> void changeState(AState<TargetStateData> aState) {
        currentState.changeState(aState);
    }
}
