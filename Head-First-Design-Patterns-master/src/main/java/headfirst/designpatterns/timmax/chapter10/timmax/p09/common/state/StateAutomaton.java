package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.classes.Classes;

public abstract class StateAutomaton implements IStateAutomaton {
    private AState currentState;

    protected final void changeState(AState newState) {
        if (currentState != null) {
            checkPosibleToChangeState(newState);
            currentState.doOnExit();
        }
        currentState = newState;
        newState.doOnEnter();
    }

    private void checkPosibleToChangeState(AState newState) {
        for (Class<? extends IState> clazz : currentState.setOfDestState) {
            if (Classes.isInstanceOf(newState, clazz)) {
                return;
            }
        }
        throw new RuntimeException("You cannot change state from '" + currentState + "' to '" + newState + "'!");
    }

    @Override
    public IState getCurrentState() {
        return currentState;
    }
}
