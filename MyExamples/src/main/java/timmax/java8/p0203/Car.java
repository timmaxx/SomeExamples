package timmax.java8.p0203;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Car {
    //  1
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    //  2
    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    //  3
    //  Непонятный для меня тип метода. Он не использует данные своего экземпляра.
    //  2 и 4 полностью справляются.
    public void follow(final Car another) {
        System.out.println("Following the " + another.toString() + ". " + this);
    }

    //  4
    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        // Первый ссылочный метод – ссылка на конструктор с синтаксисом Class::new
        // или альтернативный для дженериков (generics) Class<T>::new.
        // Обратите внимание, что конструктор не имеет аргументов.
        final Car car = Car.create(Car::new);
        System.out.println("car = " + car);
        final List<Car> cars = Arrays.asList(car);

        // Второй вариант, это ссылка на статический метод с синтаксисом Class::static_method.
        // Обратите внимание, что метод принимает ровно один параметр типа Car.
        cars.forEach(Car::collide);

        // Третий тип – ссылка на метод экземпляра произвольного объекта определенного типа с синтаксисом Class::method.
        // Обратите внимание, что никакие аргументы не принимаются методом.
        cars.forEach(Car::repair);

        // И последний, четвертый тип – ссылка на метод экземпляра определенного класса с синтаксисом instance::method.
        // Обратите внимание, что метод принимает только один параметр типа Car.
        final Car police = Car.create(Car::new);
        System.out.println("police = " + police);
        cars.forEach(police::follow);
    }
}
