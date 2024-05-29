package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.IStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.AState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class ACoinReceiverState extends AState implements IStateOfCoinReceiver {
    public ACoinReceiverState(StateContext stateContext) {
        super(stateContext);
    }

    @Override
    public void doOnEnter() {
        System.out.println("Coin receiver has entered into state '" + this + "'");
    }

    @Override
    public CoinReceiverStateContext getStateContext() {
        return (CoinReceiverStateContext) super.getStateContext();
    }
}
