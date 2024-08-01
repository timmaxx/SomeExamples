package headfirst.designpatterns.timmax.chapter10.timmax.p07.common.state;

public interface IStateContext {
    void changeState(AState aState);
    void changeState(AState aState, StateData stateData);
    StateData getData();
}
