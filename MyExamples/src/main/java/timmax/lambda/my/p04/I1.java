package timmax.lambda.my.p04;

//  Эта аннотация не обязательная, но её применение поможет указать разработчику,
//  что если он объявляет интерфейс функциональным, то должны выполняться условия функционального интерфейса.
@FunctionalInterface
public interface I1 {
    void a(int i);

    default void b(int i) {
    }
}
