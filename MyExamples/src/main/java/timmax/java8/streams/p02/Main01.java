package timmax.java8.streams.p02;

import java.util.stream.Stream;

public class Main01 {
    public static void main(String[] args) {
        Stream<String> stream =
                Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
                        .filter(s -> s.startsWith("a"));

        stream.anyMatch(s -> true);    // операция выполнится успешно
        stream.noneMatch(s -> true);   // Вылетит Exception
    }
}
