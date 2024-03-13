package headfirst.designpatterns.timmax.chapter10.p04;

public abstract class AState implements State {
    protected final GumballMachine gumballMachine;

    public AState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
}
