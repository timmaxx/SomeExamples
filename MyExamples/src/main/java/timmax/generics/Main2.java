package timmax.generics;

import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
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
}
