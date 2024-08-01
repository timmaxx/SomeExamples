package headfirst.designpatterns.timmax.chapter10.timmax.p08.common.state;

public interface IStateContext<StateData> {
    void changeState(AState<StateData> aState);
    void changeState(AState<StateData> aState, StateData stateData);
    StateData getData();
    void setData(StateData stateData);
}
