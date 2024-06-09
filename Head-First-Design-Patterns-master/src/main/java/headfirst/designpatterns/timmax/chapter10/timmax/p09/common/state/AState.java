package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

import java.util.HashSet;
import java.util.Set;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.classes.Classes;

public abstract class AState implements IState {
    private final StateAutomaton stateAutomaton;

    protected final Set<PairDestStateAndCanSwitchWithoutParams> setOfPairDestStateAndCanSwitchWithoutParams;

    public AState(StateAutomaton stateAutomaton) {
        this.stateAutomaton = stateAutomaton;
        this.setOfPairDestStateAndCanSwitchWithoutParams = new HashSet<>();
    }

    private void checkPosibleToChangeState(IState state) {
        for (PairDestStateAndCanSwitchWithoutParams pairDestStateAndCanSwitchWithoutParams : setOfPairDestStateAndCanSwitchWithoutParams) {
            if (Classes.isInstanceOf(state, pairDestStateAndCanSwitchWithoutParams.destinationStateClass())
                    && pairDestStateAndCanSwitchWithoutParams.canSwitchWithoutParams()) {
                return;
            }
        }
        throw new RuntimeException("You cannot change state from '" + this + "' to '" + state + "'!");
    }

    protected final void changeState(AState state) {
        checkPosibleToChangeState(state);
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
