package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class CRS1ReadyToReceiveCoin extends ACoinReceiverState {
    public CRS1ReadyToReceiveCoin(CoinReceiverStateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                // ToDo: в комментарии пример некорректного использования PairDestStateAndCanSwitchWithoutParams,
                //       который будет откомпилирован, но по сути не правильный (ведь сейчас менее строго extend IState).
                //       Нужно сделать так, что-бы в качестве параметра можно было передавать класс типа extend ACoinReceiverState
                // new PairDestStateAndCanSwitchWithoutParams(GMS2ReadyToReceiveCoin.class, true)
                new PairDestStateAndCanSwitchWithoutParams(CRS2CoinReceivedIntermediately.class, true)
        );
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
