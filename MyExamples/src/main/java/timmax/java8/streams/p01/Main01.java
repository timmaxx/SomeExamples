package timmax.java8.streams.p01;

import java.util.stream.Stream;

public class Main01 {
    public static void main(String[] args) {
        Stream.of("dd2", "xcdf", "zaa2", "bb1", "bb3", "cc4")
                .map(s -> {
                    //System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                })
        ;
    }
}
