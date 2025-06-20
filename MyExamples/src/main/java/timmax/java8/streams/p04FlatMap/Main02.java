package timmax.java8.streams.p04FlatMap;

import java.util.stream.IntStream;

public class Main02 {
    public static void main(String[] args) {
        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4)
                        .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
                        .forEach(f.bars::add)
                )
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }
}
