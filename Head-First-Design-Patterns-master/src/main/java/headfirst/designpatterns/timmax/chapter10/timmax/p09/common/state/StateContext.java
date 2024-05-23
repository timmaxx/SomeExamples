package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateContext implements IStateContext {
    private IState currentState;

    protected IState getCurrentState() {
        return currentState;
    }

    protected void setCurrentState(IState currentState) {
        this.currentState = currentState;
        currentState.doOnEnter();
    }

    @Override
    public final void changeState(IState state) {
        currentState.changeState(state);
    }
}
