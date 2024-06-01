package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.IStateOfGumballMachine;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.CoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.GumballDispenser;

public class GumballMachineStateContext extends StateContext implements IStateOfGumballMachine {
    private final CoinReceiver coinReceiver;
    private final GumballDispenser gumballDispenser;

    private final GMS2ReadyToReceiveCoin gms2ReadyToReceiveCoin;
    private final GMSCoinReceived gmsCoinReceived;
    private final GMSEjectingCoin gmsEjectingCoin;

    private final SPGivingGumOne spGivingGumOne;
    private final SPGivingGumWinner spGivingGumWinner;
    private final GMS1SoldOut GMS1SoldOut;

    private int countOfWinnerGumballs;


    public GumballMachineStateContext() {
        coinReceiver = new CoinReceiver();
        gumballDispenser = new GumballDispenser();

        gms2ReadyToReceiveCoin = new GMS2ReadyToReceiveCoin(this);
        gmsCoinReceived = new GMSCoinReceived(this);
        gmsEjectingCoin = new GMSEjectingCoin(this);

        spGivingGumOne = new SPGivingGumOne(this);
        GMS1SoldOut = new GMS1SoldOut(this);
        spGivingGumWinner = new SPGivingGumWinner(this);

        countOfWinnerGumballs = 0;
        setCurrentState(GMS1SoldOut);
    }

    //---- Гетеры внутренних устройств
    CoinReceiver getCoinReceiver() {
        return coinReceiver;
    }

    GumballDispenser getGumballDispenser() {
        return gumballDispenser;
    }

    //---- Гетеры собственных состояний
    final GMSCoinReceived getGmsCoinReceived() {
        return gmsCoinReceived;
    }

    final GMSEjectingCoin getGmsEjectingCoin() {
        return gmsEjectingCoin;
    }

    public GMS2ReadyToReceiveCoin getGmsReadyToReceiveCoin() {
        return gms2ReadyToReceiveCoin;
    }

    final SPGivingGumOne getSpGivingGumOne() {
        return spGivingGumOne;
    }

    final GMS1SoldOut getSpSoldOut() {
        return GMS1SoldOut;
    }

    final SPGivingGumWinner getSpGivingGumWinner() {
        return spGivingGumWinner;
    }

    //----
/*
    final void setCountOfGumballs(int maxOfGumballs) {
        countOfGumballs = maxOfGumballs;
    }

    final void incCountOfQuarters() {
        countOfQuarters++;
    }

    final void decCountOfGumballs() {
        countOfGumballs--;
    }

    final void incCountOfWinnerGumballs() {
        countOfWinnerGumballs++;
    }
*/
    // Overridden methods of class StateContext:
    @Override
    protected AGumballMachineState getCurrentState() {
        return (AGumballMachineState) super.getCurrentState();
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
                        "count of coins = " + getCoinReceiver().getCountOfCoins() + ", " +
                        "count of winner gumballs = " + countOfWinnerGumballs + ". " +
                        "Machine is " + getCurrentState() + ".";
    }
}
