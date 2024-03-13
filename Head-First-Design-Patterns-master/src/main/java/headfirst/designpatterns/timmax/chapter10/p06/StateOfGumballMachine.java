package headfirst.designpatterns.timmax.chapter10.p06;

public class StateOfGumballMachine implements State {
    StateProtected soldOutState;
    StateProtected noQuarterState;
    StateProtected hasQuarterState;
    StateProtected soldState;
    StateProtected winnerState;

    StateProtected state = soldOutState;

    int count;

    public StateOfGumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
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

    public int getCount() {
        return count;
    }

    protected void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count - 1;
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
}
