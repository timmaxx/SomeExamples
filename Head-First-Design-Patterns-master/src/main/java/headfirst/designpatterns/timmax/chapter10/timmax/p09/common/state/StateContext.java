package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateContext {
    private IState currentState;

    protected IState getCurrentState() {
        return currentState;
    }

    protected void setCurrentState(IState currentState) {
        if (this.currentState != null) {
            this.currentState.doOnExit();
        }
        this.currentState = currentState;
        currentState.doOnEnter();
    }
}
