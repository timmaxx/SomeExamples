package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import javax.lang.model.type.NullType;
import java.util.Random;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class SPHasQuarter extends AGumballMachineState<NullType> {
    private final Random randomWinner = new Random(System.currentTimeMillis());

    public SPHasQuarter(StateContext stateContext) {
        super(stateContext);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPEjectingQuarter.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPGivingGumOne.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPGivingGumWinner.class, true)
        );
    }

    // Implemented methods of the IStateOfGumballMachine interface:
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    @Override
    public void ejectQuarter() {
        changeState(getStateContext().getSpEjectingQuarter());
    }

    @Override
    public void turnCrank() {
        System.out.println("You turned...");
        int winner = randomWinner.nextInt(10);
        if ((winner == 0) && (getStateContext().getSpNoQuarter().getNumberGumballs() > 1)) {
            changeState(getStateContext().getSpGivingGumWinner());
        } else {
            changeState(getStateContext().getSpGivingGumOne());
        }
    }

    @Override
    public void refill() {
    }

    // Overridden methods of class AState:
    @Override
    public void doOnEnter() {
        super.doOnEnter();
        System.out.println("You inserted a quarter");
    }

    // Overridden methods of the Object class:
    @Override
    public String toString() {
        return "waiting for turn of crank";
    }
}
