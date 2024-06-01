package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class GDS1GumballBoxIsEmpty extends AGumballDispenserState {
    public GDS1GumballBoxIsEmpty(GumballDispenserStateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                // ToDo: в комментарии пример некорректного использования PairDestStateAndCanSwitchWithoutParams,
                //       который будет откомпилирован, но по сути не правильный (ведь сейчас менее строго extend IState).
                //       Нужно сделать так, что-бы в качестве параметра можно было передавать класс типа extend ACoinReceiverState
                // new PairDestStateAndCanSwitchWithoutParams(CRS2CoinReceivedIntermediately.class, true)
                new PairDestStateAndCanSwitchWithoutParams(GDS2ReadyToReleaseGumball.class, true)
        );
    }

    @Override
    public void refillGumballBox() {
        super.refillGumballBox();
        getStateContext()._refillGumballBox();
    }

    @Override
    public void releaseGumball() {
        super.releaseGumball();
        // Исключение
        System.out.println("You cannot to release a gumball, because there are not any gumballs in the gumball box.");
    }
}
