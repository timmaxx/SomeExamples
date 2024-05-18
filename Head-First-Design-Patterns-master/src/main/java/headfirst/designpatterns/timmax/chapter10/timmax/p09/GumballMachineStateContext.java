package headfirst.designpatterns.timmax.chapter10.timmax.p09;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.inners.*;

public class GumballMachineStateContext extends StateContext implements IStateOfGumballMachine {
    private final SPNoQuarter spNoQuarter;
    private final SPHasQuarter spHasQuarter;
    private final SPSold spSold;
    private final SPSoldOut spSoldOut;
    private final SPWinner spWinner;

    // ToDo: убрать из конструктора int numberGumballs и отдельно вызывать refill()
    public GumballMachineStateContext(int numberGumballs) {
        if (numberGumballs < 0) {
            throw new RuntimeException("Number of gumballs must be 0 or more!");
        }

        spNoQuarter = new SPNoQuarter(this);
        spHasQuarter = new SPHasQuarter(this);
        spSold = new SPSold(this);
        spSoldOut = new SPSoldOut(this);
        spWinner = new SPWinner(this);

        if (numberGumballs > 0) {
            setCurrentState(spNoQuarter);
        } else {
            setCurrentState(spSoldOut);
        }
        spNoQuarter.setNumberGumballs(numberGumballs);
    }

    public AState getSpHasQuarter() {
        return spHasQuarter;
    }

    public AState getSpNoQuarter() {
        return spNoQuarter;
    }

    public AState getSpSold() {
        return spSold;
    }

    public AState getSpSoldOut() {
        return spSoldOut;
    }

    public AState getSpWinner() {
        return spWinner;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        int numberGumballs = (Integer)(getSpNoQuarter().getData());
        if (numberGumballs > 0) {
            getSpNoQuarter().setData(numberGumballs - 1);
        }
    }

    @Override
    public AGumballMachineState getCurrentState() {
        return (AGumballMachineState) super.getCurrentState();
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
        getCurrentState().dispense();
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
