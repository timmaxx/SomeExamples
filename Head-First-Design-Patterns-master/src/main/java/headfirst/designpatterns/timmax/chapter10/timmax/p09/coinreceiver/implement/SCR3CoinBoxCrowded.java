package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class SCR3CoinBoxCrowded extends AStateOfCoinReceiver {
    public SCR3CoinBoxCrowded(CoinReceiver coinReceiver) {
        super(coinReceiver);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SCR1ReadyToReceiveCoin.class, true)
        );
    }

    @Override
    public void insertCoin() {
        super.insertCoin();
        // Исключение
        System.out.println("CR. You cannot insert a coin, because there is a problem with the coin box. But you can pull all the coins out.");
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        // Исключение
        System.out.println("CR. You cannot eject a coin, because there is no coin. But you can pull all the coins out.");
    }

    @Override
    public void acceptCoin() {
        super.acceptCoin();
        // Исключение
        System.out.println("CR. You cannot accept a coin, because there is no coin and there is a problem with the coin box. But you can pull all the coins out.");
    }

    @Override
    public void pullOutAllCoins() {
        super.pullOutAllCoins();
        getStateAutomaton()._pullOutAllCoins();
    }
}
