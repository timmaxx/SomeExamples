package headfirst.designpatterns.timmax.chapter10.p06;

public class StateOfGumballMachine {
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;

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

    protected State getState() {
        return state;
    }

    protected void setState(State state) {
        this.state = state;
    }

    protected State getSoldOutState() {
        return soldOutState;
    }

    protected State getNoQuarterState() {
        return noQuarterState;
    }

    protected State getHasQuarterState() {
        return hasQuarterState;
    }

    protected State getSoldState() {
        return soldState;
    }

    protected State getWinnerState() {
        return winnerState;
    }

    protected int getCount() {
        return count;
    }

    protected void releaseBall() {
        System.out.println("A gumball comes rolling out the slot...");
        if (count > 0) {
            count = count - 1;
        }
    }

    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
}
