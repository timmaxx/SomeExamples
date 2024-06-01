package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class CRS2CoinReceivedIntermediately extends ACoinReceiverState {
    public CRS2CoinReceivedIntermediately(CoinReceiverStateContext stateContext) {
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
        System.out.println("You cannot insert another coin, because there is already a coin. But you can eject coin.");
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
    public void emptyCoinBox() {
        super.emptyCoinBox();
        // Исключение
        System.out.println("You cannot empty the coin box, because already there is a coin. But you can eject coin.");
    }
}
