package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;

public abstract class AStateOfGumballMachine extends AState implements IStateOfGumballMachine {
    public AStateOfGumballMachine(StateContextOfGumballMachine stateContext) {
        super(stateContext);
    }

    // class AState
    @Override
    public void doOnEnter() {
        System.out.println("Gumball machine has entered into state '" + this + "'.");
    }

    @Override
    public StateContextOfGumballMachine getStateContext() {
        return (StateContextOfGumballMachine) super.getStateContext();
    }

    // interface IStateOfGumballDispenser
    @Override
    public void insertCoin() {
        System.out.println("GM. You are trying to insert a coin.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("GM. You are trying to eject a coin.");
    }

    @Override
    public void turnCrank() {
        System.out.println("GM. You are trying to turn the crank.");
    }

    @Override
    public void pullOutAllCoins() {
        System.out.println("GM. You are trying to pull all the coins out.");
    }

    @Override
    public void refillGumballBox() {
        System.out.println("GM. You are trying to refill the gumball box.");
    }
}
