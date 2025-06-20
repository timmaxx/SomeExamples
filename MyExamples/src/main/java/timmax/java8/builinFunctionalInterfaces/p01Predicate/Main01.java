package timmax.java8.builinFunctionalInterfaces.p01Predicate;

import java.util.Objects;
import java.util.function.Predicate;

public class Main01 {
    public static void main(String[] args) {
        //  Предикаты
        //  @FunctionalInterface
        //  public interface Predicate<T>

        //  Предикаты — это функции, принимающие один аргумент, и возвращающие значение типа boolean.
        //      boolean test(T t);

        //  Интерфейс содержит различные методы по умолчанию,
        //  позволяющие строить сложные условия (and, or, negate).
        //      default Predicate<T> and(Predicate<? super T> other)
        //      default Predicate<T> negate()
        //      default Predicate<T> or(Predicate<? super T> other)

        //  Статические методы:
        //      static <T> Predicate<T> isEqual(Object targetRef)
        //      static <T> Predicate<T> not(Predicate<? super T> target)

        Predicate<String> predicate = (s) -> s.length() > 0;

        // true
        System.out.println("predicate.test(\"foo\") = " + predicate.test("foo"));

        // false
        System.out.println("predicate.negate().test(\"foo\") = " + predicate.negate().test("foo"));

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

    }
}
