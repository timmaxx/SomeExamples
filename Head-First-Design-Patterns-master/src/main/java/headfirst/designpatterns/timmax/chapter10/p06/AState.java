package headfirst.designpatterns.timmax.chapter10.p06;

public abstract class AState implements StateProtected {
    protected StateOfGumballMachine stateOfGumballMachine;

    public AState(StateOfGumballMachine stateOfGumballMachine) {
        this.stateOfGumballMachine = stateOfGumballMachine;
    }
}
