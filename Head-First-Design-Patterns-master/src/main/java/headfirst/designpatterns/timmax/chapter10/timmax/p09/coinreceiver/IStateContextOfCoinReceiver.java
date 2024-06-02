package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.AStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.IStateContext;

public interface IStateContextOfCoinReceiver extends IStateContext, IStateOfCoinReceiver {
    int getCountOfCoins();

    // interface IStateContext
    @Override
    AStateOfCoinReceiver getCurrentState();
}
