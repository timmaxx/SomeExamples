package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public interface IState<StateData> {
    void changeState(AState<?> aState);
    // ToDo: Удалить, т.к. с помощью предыдущего метода можно перейти в нужное состояние,
    //  но перед этим в состояние ввести нужные данные.
    <TargetStateData> void changeState(AState<TargetStateData> aState, TargetStateData stateData);
    StateData getData();
    void setData(StateData stateData);
}
