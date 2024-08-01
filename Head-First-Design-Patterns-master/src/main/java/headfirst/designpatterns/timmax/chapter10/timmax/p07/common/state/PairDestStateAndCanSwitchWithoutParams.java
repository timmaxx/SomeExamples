package headfirst.designpatterns.timmax.chapter10.timmax.p07.common.state;

public record PairDestStateAndCanSwitchWithoutParams(
        Class<? extends AState> destinationStateClass,
        Boolean canSwitchWithoutParams) {
}
