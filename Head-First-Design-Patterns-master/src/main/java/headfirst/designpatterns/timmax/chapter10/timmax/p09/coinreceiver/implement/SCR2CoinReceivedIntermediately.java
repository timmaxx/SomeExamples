package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

public class SCR2CoinReceivedIntermediately extends AStateOfCoinReceiver {
    public SCR2CoinReceivedIntermediately(CoinReceiver coinReceiver) {
        super(coinReceiver);
        setOfDestState.add(SCR1ReadyToReceiveCoin.class);
        setOfDestState.add(SCR3CoinBoxCrowded.class);
    }

    @Override
    public void insertCoin() {
        super.insertCoin();
        // Исключение
        System.out.println("CR. You cannot insert another coin, because there is already a coin. But you can eject a coin.");
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        getStateAutomaton()._ejectCoin();
    }

    @Override
    public void acceptCoin() {
        super.acceptCoin();
        getStateAutomaton()._acceptCoin();
    }

    @Override
    public void pullOutAllCoins() {
        super.pullOutAllCoins();
        // Исключение
        System.out.println("CR. You cannot pull all the coins out, because already there is a coin. But you can eject a coin.");
    }
}
