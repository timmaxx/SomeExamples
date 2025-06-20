package timmax.java8.builinFunctionalInterfaces.p04Consumer;

import timmax.java8.Person;

import java.util.function.Consumer;

public class Main01 {
    public static void main(String[] args) {
        //  Потребители
        //  @FunctionalInterface
        //  public interface Consumer<T>

        //  Consumers – представляют собой операции, которые производятся с одним входным аргументом.
        //  Функциональный метод:
        //      void accept(T t);

        //  Методы по умолчанию:
        //      default Consumer<T> andThen(Consumer<? super T> after)

        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter.accept(new Person("Luke", "Skywalker"));
    }
}
