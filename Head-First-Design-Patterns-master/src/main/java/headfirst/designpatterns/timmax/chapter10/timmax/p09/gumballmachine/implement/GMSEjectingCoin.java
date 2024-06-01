package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class GMSEjectingCoin extends AGumballMachineState {
    public GMSEjectingCoin(StateContext stateContext) {
        super(stateContext);
		// Такой вариант не описан на стр. 442, но должен быть...
		setOfPairDestStateAndCanSwitchWithoutParams.add(
				new PairDestStateAndCanSwitchWithoutParams(GMS2ReadyToReceiveCoin.class, true)
		);
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertCoin() {
        System.out.println("You can't insert a quarter, the machine is ejecting quarter");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Please wait! Your quarter is ejecting");
    }

    @Override
    public void turnCrank() {
        System.out.println("Please wait! Your quarter is ejecting");
    }

    @Override
    public void refillGumballBox() {
        System.out.println("Not for this state");
    }

    @Override
    public void pullOutAllCoins() {
        System.out.println("Not for this state");
    }

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        super.doOnEnter();
        System.out.println("Quarter returned");
        // ???
        changeState(getStateContext().getGmsReadyToReceiveCoin());
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "ejecting quarter";
    }
}
