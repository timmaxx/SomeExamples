package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.IStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class CoinReceiverStateContext extends StateContext implements IStateOfCoinReceiver {
    public static int MAX_OF_COINS = 4;
    private int countOfCoins;

    private final CRS1ReadyToReceiveCoin crs1ReadyToReceiveCoin;
    private final CRS2CoinReceivedIntermediately crs2CoinReceivedIntermediately;
    private final CRS3CoinBoxCrowded crs3CoinBoxCrowded;

    public CoinReceiverStateContext() {
        crs1ReadyToReceiveCoin = new CRS1ReadyToReceiveCoin(this);
        crs2CoinReceivedIntermediately = new CRS2CoinReceivedIntermediately(this);
        crs3CoinBoxCrowded = new CRS3CoinBoxCrowded(this);

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

    public CRS1ReadyToReceiveCoin getCrs1ReadyToReceiveCoin() {
        return crs1ReadyToReceiveCoin;
    }

    public CRS2CoinReceivedIntermediately getCrs2CoinReceivedIntermediately() {
        return crs2CoinReceivedIntermediately;
    }

    public CRS3CoinBoxCrowded getCrs3CoinBoxCrowded() {
        return crs3CoinBoxCrowded;
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
