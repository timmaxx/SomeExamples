package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class CRS2CoinReceivedIntermediately extends AStateOfCoinReceiver {
    public CRS2CoinReceivedIntermediately(StateContextOfCoinReceiver stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(CRS1ReadyToReceiveCoin.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(CRS3CoinBoxCrowded.class, true)
        );
    }

    @Override
    public void insertCoin() {
        super.insertCoin();
        // Исключение
        System.out.println("You cannot insert another coin, because there is already a coin. But you can eject a coin.");
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        getStateContext()._ejectQuarter();
    }

    @Override
    public void acceptCoin() {
        super.acceptCoin();
        getStateContext()._acceptCoin();
    }

    @Override
    public void pullOutAllCoins() {
        super.pullOutAllCoins();
        // Исключение
        System.out.println("You cannot pull all the coins out, because already there is a coin. But you can eject a coin.");
    }
}
