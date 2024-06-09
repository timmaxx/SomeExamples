package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.IStateAutomaton;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement.AStateOfGumballMachine;

public interface IStateAutomatonOfGumballMachine extends IStateAutomaton, IStateOfGumballMachine {
    int getCountOfCoins();
    int getCountOfGumballs();

    // int getCountOfWinnerGumballs();

    // interface IStateAutomaton
    @Override
    AStateOfGumballMachine getCurrentState();
}
