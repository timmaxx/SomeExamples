package timmax.java8.builinFunctionalInterfaces.p06Optional;

import java.util.Optional;

public class Main01 {
    public static void main(String[] args) {
        //  Опциональные значения
        //  Optionals - это контейнер для значения, которое может быть null.
        //
        //  Например, вам нужен метод, который возвращает какое-то значение,
        //  но иногда он должен возвращать пустое значение.
        //  Вместо того чтобы возвращать null, в Java 8 вы можете вернуть опциональное значение.
        //
        //  Optionals не являются функциональными интерфейсами,
        //  однако являются удобным средством предотвращения всеми известным NullPointerException.

        Optional<String> optional = Optional.empty();

        //  "fallback"
        System.out.println("optional.orElse(\"fallback\") = " + optional.orElse("fallback"));

        optional = Optional.of("bam");

        //  true
        System.out.println("optional.isPresent() = " + optional.isPresent());

        //  "bam"
        System.out.println("optional.get() = " + optional.get());

        //  "bam"
        System.out.println("optional.orElse(\"fallback\") = " + optional.orElse("fallback"));

        //  "b"
        optional.ifPresent(
                s -> System.out.println(s.charAt(0))
        );
    }
}
