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

    public final SCR1ReadyToReceiveCoin getScr1ReadyToReceiveCoin() {
        return scr1ReadyToReceiveCoin;
    }

    public final SCR2CoinReceivedIntermediately getScr2CoinReceivedIntermediately() {
        return scr2CoinReceivedIntermediately;
    }

    public final SCR3CoinBoxCrowded getScr3CoinBoxCrowded() {
        return scr3CoinBoxCrowded;
    }

    // ----
    void _insertQuarter() {
        if (countOfCoins >= MAX_OF_COINS) {
            getCurrentState().changeState(getScr3CoinBoxCrowded());
            throw new RuntimeException();
        }
        getCurrentState().changeState(getScr2CoinReceivedIntermediately());
    }

    void _ejectQuarter() {
        getCurrentState().changeState(getScr1ReadyToReceiveCoin());
    }

    void _acceptCoin() {
        if (countOfCoins >= MAX_OF_COINS) {
            getCurrentState().changeState(getScr3CoinBoxCrowded());
            throw new RuntimeException();
        }
        countOfCoins++;
        if (countOfCoins >= MAX_OF_COINS) {
            getCurrentState().changeState(getScr3CoinBoxCrowded());
            return;
        }
        getCurrentState().changeState(getScr1ReadyToReceiveCoin());
    }

    void _pullOutAllCoins() {
        System.out.println("All the coins (" + getCountOfCoins() + ") have been pulled out.");
        countOfCoins = 0;
        getCurrentState().changeState(getScr1ReadyToReceiveCoin());
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
