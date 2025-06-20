package timmax.java8.builinFunctionalInterfaces.p03Supplier;

import timmax.java8.Person;
import timmax.java8.Person2;

import java.util.function.Supplier;

public class Main01 {
    public static void main(String[] args) {
        //  Поставщики

        //  @FunctionalInterface
        //  public interface Supplier<T>

        //  Suppliers – предоставляют результат заданного типа.
        //  В отличии от функций, поставщики не принимают аргументов.
        //  Функциональный метод
        //      T get();

        //  Методы по умолчанию:
        //      их нет.

        //  Статические методы:
        //      их нет.

        Supplier<Person> personSupplier = Person2::new;
        Person a = personSupplier.get();   // new Person
        System.out.println("a = " + a);
    }
}
