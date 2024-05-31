package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class CRS3CoinReceivedIntermediately extends ACoinReceiverState {
    public CRS3CoinReceivedIntermediately(StateContext stateContext) {
        super(stateContext);
    }

    @Override
    public void insertQuarter() {
        // Исключение
    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void emptyCoinBox() {
        // Исключение
    }
}
