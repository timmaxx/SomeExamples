package timmax.java8.streams.p01;

import java.util.stream.Stream;

public class Main02 {
    public static void main(String[] args) {
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s))
        ;
    }
}
