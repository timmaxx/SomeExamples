package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

public class SGD2ReadyToReleaseGumball extends AStateOfGumballDispenser {
    public SGD2ReadyToReleaseGumball(GumballDispenser gumballDispenser) {
        super(gumballDispenser);
        setOfDestState.add(SGD1GumballBoxIsEmpty.class);
        setOfDestState.add(SGD2ReadyToReleaseGumball.class);
    }

    @Override
    public void refillGumballBox() {
        super.refillGumballBox();
        getStateAutomaton()._refillGumballBox();
    }

    @Override
    public void releaseGumball() {
        super.releaseGumball();
        getStateAutomaton()._releaseGumball();
    }
}
