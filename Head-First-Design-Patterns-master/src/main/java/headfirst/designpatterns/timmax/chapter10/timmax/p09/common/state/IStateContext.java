package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public interface IStateContext {
    <TargetStateData> void changeState(AState<TargetStateData> aState);
    // ToDo: Удалить.
    <TargetStateData> void changeState(AState<TargetStateData> aState, TargetStateData stateData);
}
