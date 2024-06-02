package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.AStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.StateContextOfCoinReceiver;

public class CoinReceiver implements IStateOfCoinReceiver, IStateContextOfCoinReceiver {
    private final IStateContextOfCoinReceiver coinReceiverStateContext;

    public CoinReceiver() {
        coinReceiverStateContext = new StateContextOfCoinReceiver();
    }

    // interface IStateContextOfCoinReceiver extends IStateContext
    @Override
    public AStateOfCoinReceiver getCurrentState() {
        return coinReceiverStateContext.getCurrentState();
    }

    // interface IStateContextOfCoinReceiver
    @Override
    public int getCountOfCoins() {
        return coinReceiverStateContext.getCountOfCoins();
    }

    // interface IStateOfCoinReceiver
    @Override
    public void insertCoin() {
        coinReceiverStateContext.insertCoin();
    }

    @Override
    public void ejectCoin() {
        coinReceiverStateContext.ejectCoin();
    }

    @Override
    public void acceptCoin() {
        coinReceiverStateContext.acceptCoin();
    }

    @Override
    public void pullOutAllCoins() {
        coinReceiverStateContext.pullOutAllCoins();
    }

    // class Object
    @Override
    public String toString() {
        return coinReceiverStateContext.toString();
    }
}
