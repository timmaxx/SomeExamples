package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;

public class SGD1GumballBoxIsEmpty extends AStateOfGumballDispenser {
    public SGD1GumballBoxIsEmpty(StateContextOfGumballDispenser stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                // ToDo: в комментарии пример некорректного использования PairDestStateAndCanSwitchWithoutParams,
                //       который будет откомпилирован, но по сути не правильный (ведь сейчас менее строго extend IState).
                //       Нужно сделать так, что-бы в качестве параметра можно было передавать класс типа extend AStateOfCoinReceiver
                // new PairDestStateAndCanSwitchWithoutParams(SCR2CoinReceivedIntermediately.class, true)
                new PairDestStateAndCanSwitchWithoutParams(SGD2ReadyToReleaseGumball.class, true)
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
