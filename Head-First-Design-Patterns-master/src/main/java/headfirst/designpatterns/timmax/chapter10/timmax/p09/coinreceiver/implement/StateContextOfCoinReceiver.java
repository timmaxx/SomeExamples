package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.IStateContextOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class StateContextOfCoinReceiver extends StateContext implements IStateContextOfCoinReceiver {
    public static final int MAX_OF_COINS = 4;
    private int countOfCoins;

    private final CRS1ReadyToReceiveCoin crs1ReadyToReceiveCoin;
    private final CRS2CoinReceivedIntermediately crs2CoinReceivedIntermediately;
    private final CRS3CoinBoxCrowded crs3CoinBoxCrowded;

    public StateContextOfCoinReceiver() {
        crs1ReadyToReceiveCoin = new CRS1ReadyToReceiveCoin(this);
        crs2CoinReceivedIntermediately = new CRS2CoinReceivedIntermediately(this);
        crs3CoinBoxCrowded = new CRS3CoinBoxCrowded(this);

        countOfCoins = 0;
        changeState(crs1ReadyToReceiveCoin);
    }

    public final CRS1ReadyToReceiveCoin getCrs1ReadyToReceiveCoin() {
        return crs1ReadyToReceiveCoin;
    }

    public final CRS2CoinReceivedIntermediately getCrs2CoinReceivedIntermediately() {
        return crs2CoinReceivedIntermediately;
    }

    public final CRS3CoinBoxCrowded getCrs3CoinBoxCrowded() {
        return crs3CoinBoxCrowded;
    }

    // ----
    void _insertQuarter() {
        if (countOfCoins >= MAX_OF_COINS) {
            getCurrentState().changeState(getCrs3CoinBoxCrowded());
            throw new RuntimeException();
        }
        getCurrentState().changeState(getCrs2CoinReceivedIntermediately());
    }

    void _ejectQuarter() {
        getCurrentState().changeState(getCrs1ReadyToReceiveCoin());
    }

    void _acceptCoin() {
        if (countOfCoins >= MAX_OF_COINS) {
            getCurrentState().changeState(getCrs3CoinBoxCrowded());
            throw new RuntimeException();
        }
        countOfCoins++;
        if (countOfCoins >= MAX_OF_COINS) {
            getCurrentState().changeState(getCrs3CoinBoxCrowded());
            return;
        }
        getCurrentState().changeState(getCrs1ReadyToReceiveCoin());
    }

    void _pullOutAllCoins() {
        System.out.println("All the coins (" + getCountOfCoins() + ") have been pulled out.");
        countOfCoins = 0;
        getCurrentState().changeState(getCrs1ReadyToReceiveCoin());
    }

    // interface IStateContextOfCoinReceiver
    @Override
    public final int getCountOfCoins() {
        return countOfCoins;
    }

    // class StateContext
    @Override
    public AStateOfCoinReceiver getCurrentState() {
        return (AStateOfCoinReceiver) super.getCurrentState();
    }

    // interface IStateOfCoinReceiver
    @Override
    public void insertCoin() {
        getCurrentState().insertCoin();
    }

    @Override
    public void ejectCoin() {
        getCurrentState().ejectCoin();
    }

    @Override
    public void acceptCoin() {
        getCurrentState().acceptCoin();
    }

    @Override
    public void pullOutAllCoins() {
        getCurrentState().pullOutAllCoins();
    }

    // class Object
    @Override
    public String toString() {
        return getCurrentState().toString() + ". MAX_OF_COINS = " + MAX_OF_COINS + ". countOfCoins = " + countOfCoins;
    }
}
