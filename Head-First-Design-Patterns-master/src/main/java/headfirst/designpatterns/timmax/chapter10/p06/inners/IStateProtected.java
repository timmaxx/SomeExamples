package headfirst.designpatterns.timmax.chapter10.p06.inners;

import headfirst.designpatterns.timmax.chapter10.p06.IState;

public interface IStateProtected extends IState {
    void dispense();
    void refill();
    void setAsCurrent();
}
