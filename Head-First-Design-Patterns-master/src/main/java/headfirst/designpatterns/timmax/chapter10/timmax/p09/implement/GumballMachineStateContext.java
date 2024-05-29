package headfirst.designpatterns.timmax.chapter10.timmax.p09.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class GumballMachineStateContext extends StateContext implements IStateOfGumballMachine {
    public static int MAX_OF_GUMBALLS = 6;

    private final SPNoQuarter spNoQuarter;
    private final SPHasQuarter spHasQuarter;
    private final SPGivingGumOne spGivingGumOne;
    private final SPSoldOut spSoldOut;
    private final SPGivingGumWinner spGivingGumWinner;
    private final SPEjectingQuarter spEjectingQuarter;

    private int countOfQuarters;
    private int countOfGumballs;
    private int countOfWinnerGumballs;

    public GumballMachineStateContext() {
        spNoQuarter = new SPNoQuarter(this);
        spHasQuarter = new SPHasQuarter(this);
        spGivingGumOne = new SPGivingGumOne(this);
        spSoldOut = new SPSoldOut(this);
        spGivingGumWinner = new SPGivingGumWinner(this);
        spEjectingQuarter = new SPEjectingQuarter(this);

        setCurrentState(spSoldOut);
        countOfQuarters = 0;
        countOfGumballs = 0;
        countOfWinnerGumballs = 0;
    }

    final SPHasQuarter getSpHasQuarter() {
        return spHasQuarter;
    }

    final SPNoQuarter getSpNoQuarter() {
        return spNoQuarter;
    }

    final SPGivingGumOne getSpGivingGumOne() {
        return spGivingGumOne;
    }

    final SPSoldOut getSpSoldOut() {
        return spSoldOut;
    }

    final SPGivingGumWinner getSpGivingGumWinner() {
        return spGivingGumWinner;
    }

    final SPEjectingQuarter getSpEjectingQuarter() {
        return spEjectingQuarter;
    }

    final int getCountOfGumballs() {
        return countOfGumballs;
    }

    final void setCountOfGumballs(int maxOfGumballs) {
        countOfGumballs = maxOfGumballs;
    }

    final void incCountOfQuarters() {
        countOfQuarters++;
    }

    final void decCountOfGumballs() {
        countOfGumballs--;
    }

    final void incCountOfWinnerGumballs() {
        countOfWinnerGumballs++;
    }

    // Overridden methods of class StateContext:
    @Override
    protected AGumballMachineState getCurrentState() {
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
    }

    @Override
    public void refill() {
        getCurrentState().refill();
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return
                // "Mighty Gumball, Inc. Java-enabled Standing Gumball Model #2004\n" +
                "Inventory: count of gumballs = " + countOfGumballs + ", " +
                        "count of coins = " + countOfQuarters + ", " +
                        "count of winner gumballs = " + countOfWinnerGumballs + ". " +
                        "Machine is " + getCurrentState() + ".";
    }
}
