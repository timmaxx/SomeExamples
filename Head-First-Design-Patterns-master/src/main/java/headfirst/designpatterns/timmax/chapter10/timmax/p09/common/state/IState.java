package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public interface IState<StateData> {
    void changeState(AState<?> aState);
}
