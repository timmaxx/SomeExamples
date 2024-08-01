package headfirst.designpatterns.timmax.chapter10.timmax.p07.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p07.IStateOfGumballMachine;

public interface IStateProtected extends IStateOfGumballMachine {
    void dispense();
    void refill();
    void setAsCurrent();
}
