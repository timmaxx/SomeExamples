package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.StateContextOfGumballDispenser;

public class GumballDispenserTestDrive {
    public static void main(String[] args) {
        StateContextOfGumballDispenser gumballDispenser = new StateContextOfGumballDispenser();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.releaseGumball();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.refillGumballBox();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.releaseGumball();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.releaseGumball();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.releaseGumball();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.releaseGumball();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.releaseGumball();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.releaseGumball();
        System.out.println(gumballDispenser);
        System.out.println("----");

        gumballDispenser.releaseGumball();
        System.out.println(gumballDispenser);
        System.out.println("----");
    }
}
