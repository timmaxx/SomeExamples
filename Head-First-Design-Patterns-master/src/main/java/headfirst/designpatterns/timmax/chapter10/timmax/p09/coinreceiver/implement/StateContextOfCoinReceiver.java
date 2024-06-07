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
        // 1. Проверка, что метод можно вызывать, если нельзя, то бросить исключение.
        if (countOfCoins >= MAX_OF_COINS) {
            changeState(scr3CoinBoxCrowded);
            throw new RuntimeException("CR. It is imposible to insert a coin when the coin box is already crowded.");
        }

        // 2. Действие перед переходом в другое состояние.
        System.out.println("CR. A coin has inserted.");

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        changeState(scr2CoinReceivedIntermediately);
    }

    void _ejectCoin() {
        // 2. Действие перед переходом в другое состояние.
        System.out.println("CR. The coin has ejected.");
        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        changeState(scr1ReadyToReceiveCoin);
    }

    void _acceptCoin() {
        // 1. Проверка, что метод можно вызывать, если нельзя, то бросить исключение.
        if (countOfCoins >= MAX_OF_COINS) { // Это по сути проверка текущего состояния по основному признаку.
            changeState(scr3CoinBoxCrowded);
            throw new RuntimeException("CR. It is imposible to accept a coin when the coin box is already crowded.");
        }

        // 2. Действие перед переходом в другое состояние.
        countOfCoins++;
        System.out.println("CR. The coin has accepted.");

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        if (countOfCoins >= MAX_OF_COINS) {
            changeState(scr3CoinBoxCrowded);
            return;
        }
        changeState(scr1ReadyToReceiveCoin);
    }

    void _pullOutAllCoins() {
        // 2. Действие перед переходом в другое состояние.
        System.out.println("CR. All the coins (" + getCountOfCoins() + ") have been pulled out.");
        countOfCoins = 0;

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
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
