package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.IStateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.AStateOfGumballDispenser;

public interface IStateContextOfGumballDispenser extends IStateContext, IStateOfGumballDispenser {
    int getCountOfGumballs();

    // interface IStateContext
    @Override
    AStateOfGumballDispenser getCurrentState();
}
