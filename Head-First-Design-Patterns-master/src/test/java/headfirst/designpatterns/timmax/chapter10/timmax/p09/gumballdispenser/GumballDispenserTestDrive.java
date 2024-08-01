package headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser;

import headfirst.designpatterns.timmax.chapter10.timmax.p09.gumballdispenser.implement.GumballDispenser;

public class GumballDispenserTestDrive {
    public static void main(String[] args) {
        GumballDispenser gumballDispenser = new GumballDispenser();
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
