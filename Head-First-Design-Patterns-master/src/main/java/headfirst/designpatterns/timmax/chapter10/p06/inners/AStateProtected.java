package headfirst.designpatterns.timmax.chapter10.p06.inners;

public abstract class AStateProtected implements IStateProtected {
    protected StateOfGumballMachine stateOfGumballMachine;

    public AStateProtected(StateOfGumballMachine stateOfGumballMachine) {
        this.stateOfGumballMachine = stateOfGumballMachine;
    }
}
