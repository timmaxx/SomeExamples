package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.IStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class CoinReceiverStateContext extends StateContext implements IStateOfCoinReceiver {
    @Override
    protected ACoinReceiverState getCurrentState() {
        return (ACoinReceiverState) super.getCurrentState();
    }

    @Override
    public void insertQuarter() {
        getCurrentState().insertQuarter();
    }

    @Override
    public void ejectQuarter() {
        getCurrentState().ejectQuarter();
    }
}
