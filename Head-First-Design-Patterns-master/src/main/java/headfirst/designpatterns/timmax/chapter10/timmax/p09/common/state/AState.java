package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

import java.util.HashSet;
import java.util.Set;

public abstract class AState implements IState {
    private final StateAutomaton stateAutomaton;

    protected final Set<Class<? extends IState>> setOfDestState;

    public AState(StateAutomaton stateAutomaton) {
        this.stateAutomaton = stateAutomaton;
        this.setOfDestState = new HashSet<>();
    }

    protected final void changeState(AState state) {
        stateAutomaton.changeState(state);
    }

    protected void doOnEnter() {
    }

    protected void doOnExit() {
    }

    // Implemented methods of interface IState
    @Override
    public IStateAutomaton getStateAutomaton() {
        return stateAutomaton;
    }

    // class Object
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
