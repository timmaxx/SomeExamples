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
    public void insertQuarter() {
        // Исключение
    }

    @Override
    public void ejectQuarter() {
        // Исключение
    }

    @Override
    public void emptyCoinBox() {

    }
}
