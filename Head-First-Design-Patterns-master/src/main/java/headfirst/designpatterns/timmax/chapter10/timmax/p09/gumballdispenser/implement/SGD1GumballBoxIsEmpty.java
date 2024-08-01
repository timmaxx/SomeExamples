package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement;

public class SGD1GumballBoxIsEmpty extends AStateOfGumballDispenser {
    public SGD1GumballBoxIsEmpty(GumballDispenser gumballDispenser) {
        super(gumballDispenser);
        setOfDestState.add(
                // ToDo: в комментарии пример некорректного использования PairDestStateAndCanSwitchWithoutParams,
                //       который будет откомпилирован, но по сути не правильный (ведь сейчас менее строго extend IState).
                //       Нужно сделать так, что-бы в качестве параметра можно было передавать класс типа extend AStateOfCoinReceiver
                // SCR2CoinReceivedIntermediately.class
                SGD2ReadyToReleaseGumball.class
        );
    }

    @Override
    public void refillGumballBox() {
        super.refillGumballBox();
        getStateAutomaton()._refillGumballBox();
    }

    @Override
    public void releaseGumball() {
        super.releaseGumball();
        // Исключение
        System.out.println("GD. You cannot to release a gumball, because there are not any gumballs in the gumball box.");
    }
}
