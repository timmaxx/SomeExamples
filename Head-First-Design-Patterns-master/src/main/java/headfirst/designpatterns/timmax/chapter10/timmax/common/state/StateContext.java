package headfirst.designpatterns.timmax.chapter10.timmax.common.state;

public class StateContext implements State {
    AState currentState;

    public StateContext(AState currentState) {
        this.currentState = currentState;
    }

    @Override
    public void changeState(AState aState) {
        currentState.changeState(aState);
    }

    @Override
    public void changeState(AState aState, StateData stateData) {
        currentState.changeState(aState, stateData);
    }

    @Override
    public StateData getData() {
        return currentState.getData();
    }
}
