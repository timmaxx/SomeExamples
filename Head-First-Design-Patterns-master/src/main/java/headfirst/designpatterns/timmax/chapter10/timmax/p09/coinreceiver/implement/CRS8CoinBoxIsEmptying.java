package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class CRS8CoinBoxIsEmptying extends ACoinReceiverState {
    public CRS8CoinBoxIsEmptying(StateContext stateContext) {
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
