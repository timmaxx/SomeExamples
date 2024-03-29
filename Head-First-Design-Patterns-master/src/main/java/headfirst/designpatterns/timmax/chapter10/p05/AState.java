package headfirst.designpatterns.timmax.chapter10.p05;

public abstract class AState implements State {
    protected StateOfGumballMachine stateOfGumballMachine;

    public AState(StateOfGumballMachine stateOfGumballMachine) {
        this.stateOfGumballMachine = stateOfGumballMachine;
    }
}
