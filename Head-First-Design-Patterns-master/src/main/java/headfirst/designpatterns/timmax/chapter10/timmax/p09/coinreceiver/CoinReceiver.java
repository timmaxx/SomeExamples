package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.ACoinReceiverState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.CoinReceiverStateContext;

public class CoinReceiver implements IStateOfCoinReceiver {
    private final CoinReceiverStateContext coinReceiverStateContext;

    public CoinReceiver() {
        coinReceiverStateContext = new CoinReceiverStateContext();
    }

    public ACoinReceiverState getCurrentState() {
        return coinReceiverStateContext.getCurrentState();
    }

    public int getCountOfCoins() {
        return coinReceiverStateContext.getCountOfCoins();
    }

    @Override
    public void insertQuarter() {
        coinReceiverStateContext.insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        coinReceiverStateContext.ejectQuarter();
    }

    @Override
    public void emptyCoinBox() {
        coinReceiverStateContext.emptyCoinBox();
    }
}
