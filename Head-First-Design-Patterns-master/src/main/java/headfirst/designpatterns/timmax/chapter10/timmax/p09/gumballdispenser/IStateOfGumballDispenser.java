package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser;

public interface IStateOfGumballDispenser {
    // 1. выемка остатков гумболов.

    // 2. заправка гумболами.
    // ToDo: refillGumballBox() сделать разный (нужно ввести ёмкость бака для гумболов):
    //       1. дополнить на N гумболов (если дополнение превышает ёмкость бака, как-то обрабатывать).
    //       2. дополнить "до горлышка".
    void refillGumballBox();

    void releaseGumball();
}
