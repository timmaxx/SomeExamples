package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateContext implements IStateContext {
    private IState currentState;

    protected final void changeState(IState currentState) {
        if (this.currentState != null) {
            this.currentState.doOnExit();
        }
        this.currentState = currentState;
        currentState.doOnEnter();
    }

    @Override
    public IState getCurrentState() {
        return currentState;
    }
}
