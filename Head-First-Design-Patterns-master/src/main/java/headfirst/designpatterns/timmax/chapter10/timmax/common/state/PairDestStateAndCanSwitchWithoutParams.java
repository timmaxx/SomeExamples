package headfirst.designpatterns.timmax.chapter10.timmax.common.state;

public record PairDestStateAndCanSwitchWithoutParams(
        Class<? extends AState> destinationStateClass,
        Boolean canSwitchWithoutParams) {
}
