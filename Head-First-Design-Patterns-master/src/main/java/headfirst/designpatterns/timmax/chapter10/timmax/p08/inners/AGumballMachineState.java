package headfirst.designpatterns.timmax.chapter10.timmax.p08.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p08.GumballMachineStateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p08.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p08.common.state.AState;
import headfirst.designpatterns.timmax.chapter10.timmax.p08.common.state.StateContext;

public abstract class AGumballMachineState extends AState implements IStateOfGumballMachine {
    public AGumballMachineState(StateContext stateContext, Class<?> stateDataClass) {
        super(stateContext, stateDataClass);
    }

    public abstract void dispense();

    public final int getNumberGumballs() {
        return (Integer) getStateContext().getSpNoQuarter().getData();
    }

    @Override
    public GumballMachineStateContext getStateContext() {
        return (GumballMachineStateContext) super.getStateContext();
    }

    @Override
    public abstract void insertQuarter();

    @Override
    public abstract void ejectQuarter();

    @Override
    public abstract void turnCrank();
}
