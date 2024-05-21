package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public abstract class AGumballMachineState<StateData> extends AState<StateData> implements IStateOfGumballMachine {
    public AGumballMachineState(StateContext stateContext, Class<StateData> stateDataClass) {
        super(stateContext, stateDataClass);
    }

    protected final int getNumberGumballs() {
        return getStateContext().getSpNoQuarter().getData();
    }

    @Override
    public void doOnEnter() {
        System.out.println("Machine has entered into state '" + this + "'");
    }

    @Override
    public GumballMachineStateContext getStateContext() {
        return (GumballMachineStateContext) super.getStateContext();
    }
}
