package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class CRS4CoinIsReturning extends ACoinReceiverState {
    public CRS4CoinIsReturning(StateContext stateContext) {
        super(stateContext);
    }

    @Override
    public void insertQuarter() {
        // Исключение
    }

    @Override
    public void ejectQuarter() {
        // Исключение
    }

    @Override
    public void emptyCoinBox() {
        // Исключение
    }
}
