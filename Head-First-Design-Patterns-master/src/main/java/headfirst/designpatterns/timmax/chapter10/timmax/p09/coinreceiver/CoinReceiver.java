package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.ACoinReceiverState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.CoinReceiverStateContext;

public class CoinReceiver implements IStateOfCoinReceiver, ICoinReceiverStateContext {
    private final ICoinReceiverStateContext coinReceiverStateContext;

    public CoinReceiver() {
        coinReceiverStateContext = new CoinReceiverStateContext();
    }

    // interface ICoinReceiverStateContext extends IStateContext
    @Override
    public ACoinReceiverState getCurrentState() {
        return coinReceiverStateContext.getCurrentState();
    }

    // interface ICoinReceiverStateContext
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
