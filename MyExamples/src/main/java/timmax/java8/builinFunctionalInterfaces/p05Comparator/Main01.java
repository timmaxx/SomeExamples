package timmax.java8.builinFunctionalInterfaces.p05Comparator;

import timmax.java8.Person;

import java.util.Comparator;

public class Main01 {
    public static void main(String[] args) {
        //  Компараторы
        //  @FunctionalInterface
        //  public interface Comparator<T>

        //  Компараторы хорошо известны по предыдущим версиям Java.
        //  Java 8 добавляет в интерфейс различные методы по умолчанию.
        //      int compare(T o1, T o2);

        //  Методы по умолчанию:
        //      default Comparator<T> reversed()
        //      default Comparator<T> thenComparing(Comparator<? super T> other)
        //      default <U> Comparator<T> thenComparing(
        //          Function<? super T, ? extends U> keyExtractor,
        //          Comparator<? super U> keyComparator)
        //      default <U extends Comparable<? super U>> Comparator<T> thenComparing(
        //            Function<? super T, ? extends U> keyExtractor)
        //      default Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor)
        //      default Comparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor)
        //      default Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor)

        //  Статические методы:
        //      public static <T extends Comparable<? super T>> Comparator<T> reverseOrder()
        //      public static <T extends Comparable<? super T>> Comparator<T> naturalOrder()
        //      public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator)
        //      public static <T> Comparator<T> nullsLast(Comparator<? super T> comparator)
        //      public static <T, U> Comparator<T> comparing(
        //            Function<? super T, ? extends U> keyExtractor,
        //            Comparator<? super U> keyComparator)
        //      public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
        //            Function<? super T, ? extends U> keyExtractor)
        //      public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor)
        //      public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor)
        //      public static<T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor)

        Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());

        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");

        // > 0
        System.out.println("comparator.compare(p1, p2) = " + comparator.compare(p1, p2));

        // < 0
        System.out.println("comparator.reversed().compare(p1, p2) = " + comparator.reversed().compare(p1, p2));

        // = 0
        System.out.println("comparator.compare(p1, p1) = " + comparator.compare(p1, p1));

        // < 0
        System.out.println("comparator.compare(p2, p1) = " + comparator.compare(p2, p1));
    }
}
