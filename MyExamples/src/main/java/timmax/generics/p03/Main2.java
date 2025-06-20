package timmax.generics.p03;

import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        m1();
        m2();
    }

    public static void m1() {
        Set<?> question_Set;
        Set<? extends A> questionExtendsA_Set;
        Set<? super A> questionSuperA_Set;
        Set<A> a_Set;

        question_Set = new HashSet<Object>();
        question_Set = new HashSet<A>();
        question_Set = new HashSet<B>();

        // questionExtendsA_Set = new HashSet<Object>();
        questionExtendsA_Set = new HashSet<A>();
        questionExtendsA_Set = new HashSet<B>();

        questionSuperA_Set = new HashSet<Object>();
        questionSuperA_Set = new HashSet<A>();
        // questionSuperA_Set = new HashSet<B>();

        // a_Set = new HashSet<Object>();
        a_Set = new HashSet<A>();
        // a_Set = new HashSet<B>();

        System.out.println(question_Set);
        System.out.println(questionExtendsA_Set);
        System.out.println(questionSuperA_Set);
        System.out.println(a_Set);
    }

    public static void m2() {
        Set<Object> questionO_Set = new HashSet<>();
        Set<?> question_Set = new HashSet<>();
        Set<? extends A> questionExtendsA_A_Set = new HashSet<>(); //  new HashSet<A>();
        Set<? extends A> questionExtendsA_B_Set = new HashSet<B>();
        Set<? super A> questionSuperA_O_Set = new HashSet<Object>();
        Set<? super A> questionSuperA_A_Set = new HashSet<>();     //  new HashSet<A>();
        Set<A> a_Set = new HashSet<>();

        Object o = new Object();
        A a = new A();
        B b = new B();

        //  ----
        questionO_Set.add(o);
//        question_Set.add(o);
//        questionExtendsA_A_Set.add(o);
//        questionExtendsA_B_Set.add(o);
//        questionSuperA_O_Set.add(o);
//        questionSuperA_A_Set.add(o);
//        a_Set.add(o);

//  ----
        questionO_Set.add(a);
//        question_Set.add(a);
//        questionExtendsA_A_Set.add(a);
//        questionExtendsA_B_Set.add(a);
        questionSuperA_O_Set.add(a);
        questionSuperA_A_Set.add(a);
        a_Set.add(a);

        //  ----
        questionO_Set.add(b);
//        question_Set.add(b);
//        questionExtendsA_A_Set.add(b);
//        questionExtendsA_B_Set.add(b);
        questionSuperA_O_Set.add(b);
        questionSuperA_A_Set.add(b);
        a_Set.add(b);
    }

    public static <EA> void m3() {
        Set<EA> questionEA1_Set = new HashSet<>();

        Object o = new Object();
        A a = new A();
        B b = new B();
    }

    public static <EA extends A> void m4() {
        Set<EA> questionEA1_Set = new HashSet<>();

        Object o = new Object();
        A a = new A();
        B b = new B();
    }

    /*
    public static <EA super A> void m5() {
    }
*/

}
