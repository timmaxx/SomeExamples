package headfirst.designpatterns.timmax.chapter10.timmax.p08.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p08.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p08.common.state.StateContext;

public class SPSoldOut extends AGumballMachineState implements IStateOfGumballMachine, IStateOfGumballMachineProtected {
    public SPSoldOut(StateContext stateContext) {
        super(stateContext, null);
/*		// Такой вариант не описан на стр. 442, но должен быть...
		setOfPairDestStateAndCanSwitchWithoutParams.add(
				new PairDestStateAndCanSwitchWithoutParams(SPHasQuarter.class, true)
		);
*/
    }

    // Implemented methods of interface IStateOfGumballMachineProtected:
    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    @Override
    public void refill() {
        // ToDo: Нужно ещё наполнить (т.е. увеличить счетчик гамболов)...
        changeState(getStateContext().getSpNoQuarter());
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "sold out";
    }
}
