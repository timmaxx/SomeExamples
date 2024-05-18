package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateContext<StateData> implements IStateContext<StateData> {
    private AState<StateData> currentState;

    public AState<StateData> getCurrentState() {
        return currentState;
    }

    public void setCurrentState(AState<StateData> currentState) {
        this.currentState = currentState;
    }

    @Override
    public final void changeState(AState<StateData> aState) {
        currentState.changeState(aState);
    }

    @Override
    public final void changeState(AState<StateData> aState, StateData stateData) {
        currentState.changeState(aState, stateData);
    }

    @Override
    public final StateData getData() {
        return currentState.getData();
    }

    @Override
    public final void setData(StateData stateData) {
        currentState.setData(stateData);
    }
}
