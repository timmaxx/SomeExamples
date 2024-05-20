package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class GumballMachineStateContext extends StateContext implements IStateOfGumballMachine {
    private final SPNoQuarter spNoQuarter;
    private final SPHasQuarter spHasQuarter;
    private final SPGivingGumOne spGivingGumOne;
    private final SPSoldOut spSoldOut;
    private final SPGivingGumWinner spGivingGumWinner;
    private final SPEjectingQuarter spEjectingQuarter;

    public GumballMachineStateContext() {
        spNoQuarter = new SPNoQuarter(this);
        spHasQuarter = new SPHasQuarter(this);
        spGivingGumOne = new SPGivingGumOne(this);
        spSoldOut = new SPSoldOut(this);
        spGivingGumWinner = new SPGivingGumWinner(this);
        spEjectingQuarter = new SPEjectingQuarter(this);

        setCurrentState(spSoldOut);
        spNoQuarter.setNumberGumballs(0);
    }

    SPHasQuarter getSpHasQuarter() {
        return spHasQuarter;
    }

    SPNoQuarter getSpNoQuarter() {
        return spNoQuarter;
    }

    SPGivingGumOne getSpGivingGumOne() {
        return spGivingGumOne;
    }

    SPSoldOut getSpSoldOut() {
        return spSoldOut;
    }

    SPGivingGumWinner getSpGivingGumWinner() {
        return spGivingGumWinner;
    }

    SPEjectingQuarter getSpEjectingQuarter() {
        return spEjectingQuarter;
    }

    // Overridden methods of class StateContext:
    @Override
    protected AGumballMachineState<?> getCurrentState() {
        return (AGumballMachineState<?>) super.getCurrentState();
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertQuarter() {
        getCurrentState().insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        getCurrentState().ejectQuarter();
    }

    @Override
    public void turnCrank() {
        getCurrentState().turnCrank();
    }

    @Override
    public void refill() {
        getCurrentState().refill();
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        // result.append("Mighty Gumball, Inc. Java-enabled Standing Gumball Model #2004\n");
        int numberGumballs = spNoQuarter.getNumberGumballs();
        // result.append(super.toString()).append(". ");
        result.append("Inventory: ").append(numberGumballs).append(" gumball");
        if (numberGumballs != 1) {
            result.append("s");
        }
        // result.append("\n");
        result.append(". ");
        // result.append("Machine is ").append(currentState).append("\n");
        result.append("Machine is ").append(getCurrentState()).append(".");
        return result.toString();
    }
}
