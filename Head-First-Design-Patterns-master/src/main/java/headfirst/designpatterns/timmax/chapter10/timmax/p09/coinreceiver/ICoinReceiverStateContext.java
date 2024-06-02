package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.ACoinReceiverState;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.IStateContext;

public interface ICoinReceiverStateContext extends IStateContext, IStateOfCoinReceiver {
    int getCountOfCoins();

    // interface IStateContext
    @Override
    ACoinReceiverState getCurrentState();
}
