package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.IStateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement.AStateOfGumballMachine;

public interface IStateContextOfGumballMachine extends IStateContext, IStateOfGumballMachine {
    int getCountOfCoins();
    int getCountOfGumballs();

    // int getCountOfWinnerGumballs();

    // interface IStateContext
    @Override
    AStateOfGumballMachine getCurrentState();
}
