package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateContext implements IStateContext {
    private AState currentState;

    protected AState getCurrentState() {
        return currentState;
    }

    protected void setCurrentState(AState currentState) {
        this.currentState = currentState;
        currentState.doOnEnter();
    }

    @Override
    public final void changeState(AState aState) {
        currentState.changeState(aState);
    }
}
