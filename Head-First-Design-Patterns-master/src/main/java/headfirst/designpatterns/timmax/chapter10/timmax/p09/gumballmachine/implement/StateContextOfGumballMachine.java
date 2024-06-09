package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.CoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.SCR1ReadyToReceiveCoin;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.SCR2CoinReceivedIntermediately;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.SGD2ReadyToReleaseGumball;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.IStateContextOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.GumballDispenser;

public class StateContextOfGumballMachine extends StateContext implements IStateContextOfGumballMachine {
    private final CoinReceiver coinReceiver;
    private final GumballDispenser gumballDispenser;

    private final SGM1SoldOutOrCoinBoxCrowded sgm1SoldOutOrCoinBoxCrowded;
    private final SGM2ReadyToReceiveCoinAndDispenseGumball sgm2ReadyToReceiveCoinAndDispenseGumball;
    private final SGM3CoinReceivedIntermediately sgm3CoinReceivedIntermediately;

    // private int countOfWinnerGumballs;

    public StateContextOfGumballMachine() {
        coinReceiver = new CoinReceiver();
        gumballDispenser = new GumballDispenser();

        sgm1SoldOutOrCoinBoxCrowded = new SGM1SoldOutOrCoinBoxCrowded(this);
        sgm2ReadyToReceiveCoinAndDispenseGumball = new SGM2ReadyToReceiveCoinAndDispenseGumball(this);
        sgm3CoinReceivedIntermediately = new SGM3CoinReceivedIntermediately(this);

        // countOfWinnerGumballs = 0;
        changeState(sgm1SoldOutOrCoinBoxCrowded);
    }

    //----
    void _insertCoin() {
        // 1. Проверка, что метод можно вызывать. Если нельзя, то бросить исключение.

        // 2. Действие перед переходом в другое состояние.
        coinReceiver.insertCoin();

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        if (gumballDispenser.getCurrentState() instanceof SGD2ReadyToReleaseGumball &&
                coinReceiver.getCurrentState() instanceof SCR2CoinReceivedIntermediately
        ) {
            changeState(sgm3CoinReceivedIntermediately);
        } else {
            changeState(sgm1SoldOutOrCoinBoxCrowded);
        }
    }

    void _ejectCoin() {
        // 1. Проверка, что метод можно вызывать. Если нельзя, то бросить исключение.

        // 2. Действие перед переходом в другое состояние.
        coinReceiver.ejectCoin();

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        if (gumballDispenser.getCurrentState() instanceof SGD2ReadyToReleaseGumball &&
                coinReceiver.getCurrentState() instanceof SCR1ReadyToReceiveCoin
        ) {
            changeState(sgm2ReadyToReceiveCoinAndDispenseGumball);
        } else {
            changeState(sgm1SoldOutOrCoinBoxCrowded);
        }
    }

    void _turnCrank() {
        // 1. Проверка, что метод можно вызывать. Если нельзя, то бросить исключение.
        // ToDo: По общему правилу, должно вызываться исключение.
        if (!(coinReceiver.getCurrentState() instanceof SCR2CoinReceivedIntermediately) ||
                !(gumballDispenser.getCurrentState() instanceof SGD2ReadyToReleaseGumball)) {
            return;
        }

        // 2. Действие перед переходом в другое состояние.
        coinReceiver.acceptCoin();
        // ToDo: Здесь как-то сгенерировать выдачу 1 или 2 (или N) гумбола
        gumballDispenser.releaseGumball();

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        if (gumballDispenser.getCurrentState() instanceof SGD2ReadyToReleaseGumball &&
                coinReceiver.getCurrentState() instanceof SCR1ReadyToReceiveCoin
        ) {
            changeState(sgm2ReadyToReceiveCoinAndDispenseGumball);
        } else {
            changeState(sgm1SoldOutOrCoinBoxCrowded);
        }
    }

    void _refillGumballBox() {
        // 1. Проверка, что метод можно вызывать. Если нельзя, то бросить исключение.

        // 2. Действие перед переходом в другое состояние.
        gumballDispenser.refillGumballBox();

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        if (gumballDispenser.getCurrentState() instanceof SGD2ReadyToReleaseGumball &&
                coinReceiver.getCurrentState() instanceof SCR1ReadyToReceiveCoin
        ) {
            changeState(sgm2ReadyToReceiveCoinAndDispenseGumball);
        } else {
            changeState(sgm1SoldOutOrCoinBoxCrowded);
        }
    }

    void _pullOutAllCoins() {
        // 1. Проверка, что метод можно вызывать. Если нельзя, то бросить исключение.

        // 2. Действие перед переходом в другое состояние.
        coinReceiver.pullOutAllCoins();

        // 3. Выбор состояния, в которое нужно перейти и переход в него.
        if (gumballDispenser.getCurrentState() instanceof SGD2ReadyToReleaseGumball &&
                coinReceiver.getCurrentState() instanceof SCR1ReadyToReceiveCoin
        ) {
            changeState(sgm3CoinReceivedIntermediately);
        } else {
            changeState(sgm1SoldOutOrCoinBoxCrowded);
        }
    }

    // interface IStateContextOfGumballMachine
    @Override
    public final int getCountOfCoins() {
        return coinReceiver.getCountOfCoins();
    }

    @Override
    public final int getCountOfGumballs() {
        return gumballDispenser.getCountOfGumballs();
    }
/*
    @Override
    public final int getCountOfWinnerGumballs() {
        return countOfWinnerGumballs;
    }
*/
    // Overridden methods of class StateContext:
    @Override
    public AStateOfGumballMachine getCurrentState() {
        return (AStateOfGumballMachine) super.getCurrentState();
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertCoin() {
        getCurrentState().insertCoin();
    }

    @Override
    public void ejectCoin() {
        getCurrentState().ejectCoin();
    }

    @Override
    public void turnCrank() {
        getCurrentState().turnCrank();
    }

    @Override
    public void refillGumballBox() {
        getCurrentState().refillGumballBox();
    }

    @Override
    public void pullOutAllCoins() {
        getCurrentState().pullOutAllCoins();
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return
                // "Mighty Gumball, Inc. Java-enabled Standing Gumball Model #2004\n" +
                "Inventory: count of gumballs = " + gumballDispenser.getCountOfGumballs() + ", " +
                        "count of coins = " + coinReceiver.getCountOfCoins() + /*", " +
                        "count of winner gumballs = " + countOfWinnerGumballs + */". " +
                        "Machine is " + getCurrentState() + ".";
    }
}
