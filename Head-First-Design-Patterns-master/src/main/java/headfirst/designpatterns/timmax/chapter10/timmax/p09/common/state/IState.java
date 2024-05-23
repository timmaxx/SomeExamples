package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public interface IState {
    void changeState(IState state);
    void doOnEnter();
}
