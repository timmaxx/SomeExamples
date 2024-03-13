package headfirst.designpatterns.timmax.chapter10.p06.inners;

import headfirst.designpatterns.timmax.chapter10.p06.State;

public interface StateProtected extends State {
    void dispense();
    void refill();
}
