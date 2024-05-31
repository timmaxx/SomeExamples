package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.IStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class CoinReceiverStateContext extends StateContext implements IStateOfCoinReceiver {
    public static int MAX_OF_COINS = 4;
    private int countOfCoins;

    private final CRS1ReadyToReceiveCoin crs1ReadyToReceiveCoin;
    private final CRS2CoinReceivingIntermediately crs2CoinReceivingIntermediately;
    private final CRS3CoinReceivedIntermediately crs3CoinReceivedIntermediately;
    private final CRS4CoinIsReturning crs4CoinIsReturning;
    private final CRS5CoinReceivingFinally crs5CoinReceivingFinally;
    private final CRS6CoinReceivedFinally crs6CoinReceivedFinally;
    private final CRS7CoinBoxCrowded crs7CoinBoxCrowded;
    private final CRS8EmptyingCoinBox crs8EmptyingCoinBox;

    public CoinReceiverStateContext() {
        crs1ReadyToReceiveCoin = new CRS1ReadyToReceiveCoin(this);
        crs2CoinReceivingIntermediately = new CRS2CoinReceivingIntermediately(this);
        crs3CoinReceivedIntermediately = new CRS3CoinReceivedIntermediately(this);
        crs4CoinIsReturning = new CRS4CoinIsReturning(this);
        crs5CoinReceivingFinally = new CRS5CoinReceivingFinally(this);
        crs6CoinReceivedFinally = new CRS6CoinReceivedFinally(this);
        crs7CoinBoxCrowded = new CRS7CoinBoxCrowded(this);
        crs8EmptyingCoinBox = new CRS8EmptyingCoinBox(this);

        countOfCoins = 0;
        setCurrentState(crs1ReadyToReceiveCoin);
    }

    public int getCountOfCoins() {
        return countOfCoins;
    }

    @Override
    public ACoinReceiverState getCurrentState() {
        return (ACoinReceiverState) super.getCurrentState();
    }

    public CRS1ReadyToReceiveCoin getCrsReadyToReceiveCoin() {
        return crs1ReadyToReceiveCoin;
    }

    public CRS3CoinReceivedIntermediately getCrsCoinReceived() {
        return crs3CoinReceivedIntermediately;
    }

    public CRS4CoinIsReturning getCrsCoinReturn() {
        return crs4CoinIsReturning;
    }

    public CRS7CoinBoxCrowded getCrsCrowded() {
        return crs7CoinBoxCrowded;
    }

    @Override
    public void insertQuarter() {
        getCurrentState().insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        getCurrentState().ejectQuarter();
    }

    @Override
    public void emptyCoinBox() {
        getCurrentState().emptyCoinBox();
    }
}
