package timmax.mutually_exclusive_interfaces.p01;

public interface I1 {
    default I1 doNothing() {
        return null;
    }
}
