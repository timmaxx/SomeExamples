package headfirst.designpatterns.timmax.chapter10.p06.inners;

import headfirst.designpatterns.timmax.chapter10.p06.IState;

public class StateOfGumballMachine implements IState {
    private final IStateProtected iSPSoldOut;
    private final IStateProtected iSPNoQuarter;
    private final IStateProtected iSPHasQuarter;
    private final IStateProtected iSPSold;
    private final IStateProtected iSPWinner;

    private IStateProtected iSPCurrent;
    private int count;

    public StateOfGumballMachine(int numberGumballs) {
        iSPSoldOut = new SPSoldOut(this);
        iSPNoQuarter = new SPNoQuarter(this);
        iSPHasQuarter = new SPHasQuarter(this);
        iSPSold = new SPSold(this);
        iSPWinner = new SPWinner(this);
        count = numberGumballs;
        if (numberGumballs > 0) {
            iSPCurrent = iSPNoQuarter;
        } else {
            iSPCurrent = iSPSoldOut;
        }
    }

    void setISPCurrent(IStateProtected iSPCurrent) {
        this.iSPCurrent = iSPCurrent;
    }

    IStateProtected getISPSoldOut() {
        return iSPSoldOut;
    }

    IStateProtected getIStateProtectedNoQuarter() {
        return iSPNoQuarter;
    }

    IStateProtected getISPHasQuarter() {
        return iSPHasQuarter;
    }

    IStateProtected getISPSold() {
        return iSPSold;
    }

    IStateProtected getISPWinner() {
        return iSPWinner;
    }

    int getCount() {
        return count;
    }

    void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count--;
        }
    }

    // Implemented methods of interface IState:
    @Override
    public void insertQuarter() {
        iSPCurrent.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        iSPCurrent.ejectQuarter();
    }

    @Override
    public void turnCrank() {
        iSPCurrent.turnCrank();
        iSPCurrent.dispense();
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Mighty Gumball, Inc. Java-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: ").append(count).append(" gumball");
        if (getCount() != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is ").append(iSPCurrent).append("\n");
        return result.toString();
    }
}
