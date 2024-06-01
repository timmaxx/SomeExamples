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
    public void insertCoin() {
        super.insertCoin();
        getStateContext()._insertQuarter();
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        // Исключение
        System.out.println("You cannot eject a coin, because there is no coin. But you can insert a coin" + /* or empty the coin box*/ ".");
    }

    @Override
    public void acceptCoin() {
        super.acceptCoin();
        // Исключение
        System.out.println("You cannot accept a coin, because there is no coin. But you can insert a coin" + /* or empty the coin box*/ ".");
    }

    @Override
    public void pullOutAllCoins() {
        super.pullOutAllCoins();
        getStateContext()._pullOutAllCoins();
    }
}
