package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import javax.lang.model.type.NullType;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

// Думаю, этот клас мог-бы стать наследником SPSold. И тогда дублирующийся код ушёл-бы в базовый класс.
public class SPWinner extends AGumballMachineState<NullType> implements IStateOfGumballMachineProtected {
    public SPWinner(StateContext stateContext) {
        super(stateContext, null);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPSoldOut.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPNoQuarter.class, true)
        );
    }

    // Implemented methods of interface IStateOfGumballMachineProtected:
    @Override
    public void dispense() {
        getStateContext().releaseBall();
        if (getNumberGumballs() == 0) {
            changeState(getStateContext().getSpSoldOut());
            return;
        }

        getStateContext().releaseBall();
        System.out.println("You're a winner! You got two gumballs for your quarter");
        if (getNumberGumballs() > 0) {
            changeState(getStateContext().getSpNoQuarter());
        } else {
            changeState(getStateContext().getSpSoldOut());
        }
    }

    @Override
    public void refill() {
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning again doesn't get you another gumball!");
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "dispensing two gumballs for your quarter, because you're a winner!";
    }
}
