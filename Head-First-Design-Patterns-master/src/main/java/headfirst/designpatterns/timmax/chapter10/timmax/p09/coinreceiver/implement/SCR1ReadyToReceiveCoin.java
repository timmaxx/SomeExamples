package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

public class SCR1ReadyToReceiveCoin extends AStateOfCoinReceiver {
    public SCR1ReadyToReceiveCoin(CoinReceiver coinReceiver) {
        super(coinReceiver);
        setOfDestState.add(
                // ToDo: в комментарии пример некорректного использования PairDestStateAndCanSwitchWithoutParams,
                //       который будет откомпилирован, но по сути не правильный (ведь сейчас менее строго extend IState).
                //       Нужно сделать так, что-бы в качестве параметра можно было передавать класс типа extend AStateOfCoinReceiver
                // SGM2ReadyToReceiveCoinAndDispenseGumball.class
                SCR2CoinReceivedIntermediately.class
        );
    }

    @Override
    public void insertCoin() {
        super.insertCoin();
        getStateAutomaton()._insertCoin();
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        // Исключение
        System.out.println("CR. You cannot eject a coin, because there is no coin. But you can insert a coin" + /* or empty the coin box*/ ".");
    }

    @Override
    public void acceptCoin() {
        super.acceptCoin();
        // Исключение
        System.out.println("CR. You cannot accept a coin, because there is no coin. But you can insert a coin" + /* or empty the coin box*/ ".");
    }

    @Override
    public void pullOutAllCoins() {
        super.pullOutAllCoins();
        getStateAutomaton()._pullOutAllCoins();
    }
}
