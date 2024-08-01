package headfirst.designpatterns.timmax.chapter10.timmax.p07.common.state;

public class StateContext implements IStateContext {
    AState currentState;

    public StateContext(AState currentState) {
        this.currentState = currentState;
    }

    @Override
    public final void changeState(AState aState) {
        currentState.changeState(aState);
    }

    @Override
    public final void changeState(AState aState, StateData stateData) {
        currentState.changeState(aState, stateData);
    }

    @Override
    public final StateData getData() {
        return currentState.getData();
    }
}
