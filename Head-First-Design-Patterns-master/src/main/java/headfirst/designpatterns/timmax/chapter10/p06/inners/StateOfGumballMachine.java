package headfirst.designpatterns.timmax.chapter10.p06.inners;

import headfirst.designpatterns.timmax.chapter10.p06.State;

public class StateOfGumballMachine implements State {
    private final StateProtected soldOutState;
    private final StateProtected noQuarterState;
    private final StateProtected hasQuarterState;
    private final StateProtected soldState;
    private final StateProtected winnerState;

    private StateProtected state;
    private int count;

    public StateOfGumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        } else {
            state = soldOutState;
        }
    }

    protected StateProtected getState() {
        return state;
    }

    protected void setState(StateProtected state) {
        this.state = state;
    }

    protected StateProtected getSoldOutState() {
        return soldOutState;
    }

    protected StateProtected getNoQuarterState() {
        return noQuarterState;
    }

    protected StateProtected getHasQuarterState() {
        return hasQuarterState;
    }

    protected StateProtected getSoldState() {
        return soldState;
    }

    protected StateProtected getWinnerState() {
        return winnerState;
    }

    protected int getCount() {
        return count;
    }

    protected void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count--;
        }
    }

    @Override
    public void insertQuarter() {
        state.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    @Override
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Mighty Gumball, Inc. Java-enabled Standing Gumball Model #2004\n");
        result.append("Inventory: ").append(count).append(" gumball");
        if (getCount() != 1) {
            result.append("s");
        }
        result.append("\n");
        result.append("Machine is ").append(state).append("\n");
        return result.toString();
    }
}
