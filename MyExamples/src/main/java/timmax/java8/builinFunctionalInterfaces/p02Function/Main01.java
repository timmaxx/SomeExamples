package timmax.java8.builinFunctionalInterfaces.p02Function;

import java.util.function.Function;

public class Main01 {
    public static void main(String[] args) {
        //  Функции

        //  @FunctionalInterface
        //  public interface Function<T, R>

        //  Функции принимают один аргумент и возвращают некоторый результат.
        //  Функциональный метод
        //      R apply(T t);

        //  Методы по умолчанию могут использоваться для построения цепочек вызовов (compose, andThen):
        //      default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
        //      default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)

        //  Статические методы:
        //      static <T> Function<T, T> identity()

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println("backToString.apply(\"123\") = " + backToString.apply("123"));

        Integer a = toInteger.apply("135791113");
        System.out.println("a = " + a);

        Function<Integer, String> integerToString = String::valueOf;
        String b = integerToString.apply(a);
        System.out.println("b = " + b);
    }
}
