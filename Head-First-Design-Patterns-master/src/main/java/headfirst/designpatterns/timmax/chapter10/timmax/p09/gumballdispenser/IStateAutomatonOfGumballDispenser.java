package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.IStateAutomaton;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.AStateOfGumballDispenser;

public interface IStateAutomatonOfGumballDispenser extends IStateAutomaton, IStateOfGumballDispenser {
    int getCountOfGumballs();

    // interface IStateAutomaton
    @Override
    AStateOfGumballDispenser getCurrentState();
}
