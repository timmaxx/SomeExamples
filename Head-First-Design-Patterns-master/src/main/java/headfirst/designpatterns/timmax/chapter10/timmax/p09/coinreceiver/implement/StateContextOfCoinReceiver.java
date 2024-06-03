package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.IStateContextOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class StateContextOfCoinReceiver extends StateContext implements IStateContextOfCoinReceiver {
    public static final int MAX_OF_COINS = 4;

    private final SCR1ReadyToReceiveCoin scr1ReadyToReceiveCoin;
    private final SCR2CoinReceivedIntermediately scr2CoinReceivedIntermediately;
    private final SCR3CoinBoxCrowded scr3CoinBoxCrowded;

    private int countOfCoins;

    public StateContextOfCoinReceiver() {
        scr1ReadyToReceiveCoin = new SCR1ReadyToReceiveCoin(this);
        scr2CoinReceivedIntermediately = new SCR2CoinReceivedIntermediately(this);
        scr3CoinBoxCrowded = new SCR3CoinBoxCrowded(this);

        countOfCoins = 0;
        changeState(scr1ReadyToReceiveCoin);
    }

    // ----
    void _insertCoin() {
        if (countOfCoins >= MAX_OF_COINS) {
            changeState(scr3CoinBoxCrowded);
            throw new RuntimeException("It is imposible to insert a coin when the coin box is already crowded.");
        }
        changeState(scr2CoinReceivedIntermediately);
    }

    void _ejectCoin() {
        changeState(scr1ReadyToReceiveCoin);
    }

    void _acceptCoin() {
        if (countOfCoins >= MAX_OF_COINS) {
            changeState(scr3CoinBoxCrowded);
            throw new RuntimeException("It is imposible to accept a coin when the coin box is already crowded.");
        }
        countOfCoins++;
        if (countOfCoins >= MAX_OF_COINS) {
            changeState(scr3CoinBoxCrowded);
            return;
        }
        changeState(scr1ReadyToReceiveCoin);
    }

    void _pullOutAllCoins() {
        System.out.println("All the coins (" + getCountOfCoins() + ") have been pulled out.");
        countOfCoins = 0;
        changeState(scr1ReadyToReceiveCoin);
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
