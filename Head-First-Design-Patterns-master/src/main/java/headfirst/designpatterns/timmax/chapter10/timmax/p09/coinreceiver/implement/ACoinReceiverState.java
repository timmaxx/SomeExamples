package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.IStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;

public abstract class ACoinReceiverState extends AState implements IStateOfCoinReceiver {
    public ACoinReceiverState(CoinReceiverStateContext stateContext) {
        super(stateContext);
    }

    // class AState
    @Override
    public void doOnEnter() {
        super.doOnEnter();
        System.out.println("Coin receiver has entered into state '" + this + "'");
    }

    @Override
    public CoinReceiverStateContext getStateContext() {
        return (CoinReceiverStateContext) super.getStateContext();
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
