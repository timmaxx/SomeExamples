package headfirst.designpatterns.timmax.chapter10.timmax.p09.common.state;

public record PairDestStateAndCanSwitchWithoutParams(
        Class<? extends IState> destinationStateClass,
        Boolean canSwitchWithoutParams) {
}
