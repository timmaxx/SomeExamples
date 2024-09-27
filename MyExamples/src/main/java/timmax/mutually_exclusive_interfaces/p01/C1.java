package timmax.mutually_exclusive_interfaces.p01;

//  Mutually exclusive interfaces
//  Взаимоисключающие интерфейсы

//  Не получится объявить класс, как реализующий одновременно два интерфейса, если в каждом из интерфейсов есть
//  метод:
//  - с одинаковой сигнатурой,
//  - различающимися типом возвращаемого значения,
//  - эти типы не преобразуемы друг к другу.
public class C1 /*implements I1, I2*/ {
/*
    @Override
    public I2 doNothing() {
        return I2.super.doNothing();
    }
*/
}
