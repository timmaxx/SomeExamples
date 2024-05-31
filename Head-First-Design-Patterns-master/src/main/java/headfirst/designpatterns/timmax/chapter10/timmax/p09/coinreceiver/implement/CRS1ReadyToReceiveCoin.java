package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class CRS1ReadyToReceiveCoin extends ACoinReceiverState {
    public CRS1ReadyToReceiveCoin(StateContext stateContext) {
        super(stateContext);
    }

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {
        // Исключение
    }

    @Override
    public void emptyCoinBox() {

    }
}
