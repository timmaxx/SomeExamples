package timmax.mutually_exclusive_interfaces.p01;

public interface I2 {
    default I2 doNothing() {
        return null;
    }
}
