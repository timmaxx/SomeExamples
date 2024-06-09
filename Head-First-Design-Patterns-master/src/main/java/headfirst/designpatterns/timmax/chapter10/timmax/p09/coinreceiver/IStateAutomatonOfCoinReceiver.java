package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement.AStateOfCoinReceiver;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.IStateAutomaton;

public interface IStateAutomatonOfCoinReceiver extends IStateAutomaton, IStateOfCoinReceiver {
    int getCountOfCoins();

    // interface IStateAutomaton
    @Override
    AStateOfCoinReceiver getCurrentState();
}
