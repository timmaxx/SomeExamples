package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.IStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;

public abstract class AStateOfCoinReceiver extends AState implements IStateOfCoinReceiver {
    public AStateOfCoinReceiver(StateContextOfCoinReceiver stateContext) {
        super(stateContext);
    }

    // class AState
    @Override
    public void doOnEnter() {
        super.doOnEnter();
        System.out.println("Coin receiver has entered into state '" + this + "'.");
    }

    @Override
    public StateContextOfCoinReceiver getStateContext() {
        return (StateContextOfCoinReceiver) super.getStateContext();
    }

    // interface IStateOfCoinReceiver
    @Override
    public void insertCoin() {
        System.out.println("You are trying to insert a coin.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("You are trying to eject a coin.");
    }

    @Override
    public void acceptCoin() {
        System.out.println("You are trying to accept a coin.");
    }

    @Override
    public void pullOutAllCoins() {
        System.out.println("You are trying to pull all the coins out.");
    }
}
