package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballmachine.implement;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.GDS2ReadyToReleaseGumball;

public class GMS1SoldOut extends AGumballMachineState {
    public GMS1SoldOut(StateContext stateContext) {
        super(stateContext);
		// Такой вариант не описан на стр. 442, но должен быть...
		setOfPairDestStateAndCanSwitchWithoutParams.add(
				new PairDestStateAndCanSwitchWithoutParams(GMS2ReadyToReceiveCoin.class, true)
		);
    }

    // Implemented methods of interface IStateOfGumballMachine:
    @Override
    public void insertCoin() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectCoin() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned, but there are no gumballs");
    }

    @Override
    public void refillGumballBox() {
        getStateContext().getGumballDispenser().refillGumballBox();
        if (getStateContext().getGumballDispenser().getCurrentState() instanceof GDS2ReadyToReleaseGumball) {
            changeState(getStateContext().getGmsReadyToReceiveCoin());
        }
    }

    @Override
    public void pullOutAllCoins() {
        // ToDo
    }

    // Overridden methods of class Object:
    @Override
    public String toString() {
        return "sold out";
    }
}
