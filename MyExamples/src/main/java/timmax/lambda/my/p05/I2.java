package timmax.lambda.my.p05;

//  Эта аннотация не обязательная, но её применение поможет указать разработчику,
//  что если он объявляет интерфейс функциональным, то должны выполняться условия функционального интерфейса.
@FunctionalInterface
public interface I2 {
    void a(int i, long l);

    default void b(int i) {
    }
}
