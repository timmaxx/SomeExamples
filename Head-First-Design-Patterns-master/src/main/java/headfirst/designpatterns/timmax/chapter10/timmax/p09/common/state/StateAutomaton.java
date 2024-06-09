package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public abstract class StateAutomaton implements IStateAutomaton {
    private AState currentState;

    protected final void changeState(AState newState) {
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
