package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import javax.lang.model.type.NullType;
import java.util.Random;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.PairDestStateAndCanSwitchWithoutParams;
import headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state.StateContext;

public class SPHasQuarter extends AGumballMachineState<NullType> implements IStateOfGumballMachineProtected {
    private final Random randomWinner = new Random(System.currentTimeMillis());

    public SPHasQuarter(StateContext stateContext) {
        super(stateContext, null);
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPEjectingQuarter.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPSold.class, true)
        );
        setOfPairDestStateAndCanSwitchWithoutParams.add(
                new PairDestStateAndCanSwitchWithoutParams(SPWinner.class, true)
        );
    }

    // Implemented methods of interface IStateOfGumballMachineProtected:
    @Override
    public void refill() {
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
        if ((winner == 0) && (getNumberGumballs() > 1)) {
            changeState(getStateContext().getSpWinner());
        } else {
            changeState(getStateContext().getSpSold());
        }
    }

    // Overridden methods of the Object class:
    @Override
    public String toString() {
        return "waiting for turn of crank";
    }

    @Override
    public void doOnEnter() {
        super.doOnEnter();
        System.out.println("You inserted a quarter");
    }
}
