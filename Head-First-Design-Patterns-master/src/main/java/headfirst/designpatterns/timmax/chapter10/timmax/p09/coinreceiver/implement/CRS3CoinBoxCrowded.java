package headfirst.designpatterns.timmax.chapter10.timmax.p09.coinreceiver.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class CRS3CoinBoxCrowded extends ACoinReceiverState {
    public CRS3CoinBoxCrowded(CoinReceiverStateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(CRS1ReadyToReceiveCoin.class, true)
        );
    }

    @Override
    public void insertCoin() {
        super.insertCoin();
        // Исключение
        System.out.println("You cannot insert a coin, because there is a problem with the coin box. But you can empty the coin box.");
    }

    @Override
    public void ejectCoin() {
        super.ejectCoin();
        // Исключение
        System.out.println("You cannot eject a coin, because there is no coin. But you can empty the coin box.");
    }

    @Override
    public void acceptCoin() {
        super.acceptCoin();
        // Исключение
        System.out.println("You cannot accept a coin, because there is no coin and there is a problem with the coin box. But you can empty the coin box.");
    }

    @Override
    public void emptyCoinBox() {
        super.emptyCoinBox();
        getStateContext()._emptyCoinBox();
    }
}
