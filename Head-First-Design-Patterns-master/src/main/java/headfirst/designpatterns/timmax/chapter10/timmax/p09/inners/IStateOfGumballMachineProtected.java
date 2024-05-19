package headfirst.designpatterns.timmax.chapter10.timmax.p09.inners;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.IStateOfGumballMachine;

public interface IStateOfGumballMachineProtected extends IStateOfGumballMachine {
    // ToDo: refill() сделать разный (нужно ввести ёмкость бака для гумболов):
    //       1. дополнить на N гумболов (если дополнение превышает ёмкость бака, как-то обрабатывать).
    //       2. дополнить "до горлышка".
    void refill();
}
