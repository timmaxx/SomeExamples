package timmax.java8.streams.p02;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main02 {
    public static void main(String[] args) {
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));

        // операция пройдет успешно
        System.out.println("streamSupplier.get().anyMatch(s -> true) = " + streamSupplier.get().anyMatch(s -> true));

        // здесь также все будет ok
        System.out.println("streamSupplier.get().noneMatch(s -> true) = " + streamSupplier.get().noneMatch(s -> true));
    }
}
