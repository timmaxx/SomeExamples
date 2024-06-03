package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateContext implements IStateContext {
    private IState currentState;

    @Override
    public final void changeState(IState newState) {
        if (this.currentState != null) {
            this.currentState.doOnExit();
        }
        this.currentState = newState;
        newState.doOnEnter();
    }

    @Override
    public IState getCurrentState() {
        return currentState;
    }
}
