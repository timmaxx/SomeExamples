package timmax.generics;

public class Main {
    public static void main(String[] args) {
        Class<?> question_Class;
        Class<? extends A> questionExtendsA_Class;
        Class<? super A> questionSuperA_Class;
        Class<A> a_Class;

        question_Class = Object.class;
        question_Class = A.class;
        question_Class = B.class;

        // questionExtendsA_Class = Object.class;
        questionExtendsA_Class = A.class;
        questionExtendsA_Class = B.class;

        questionSuperA_Class = Object.class;
        questionSuperA_Class = A.class;
        // questionSuperA_Class = B.class;

        // a_Class = Object.class;
        a_Class = A.class;
        // a_Class = B.class;

        System.out.println(question_Class);
        System.out.println(questionExtendsA_Class);
        System.out.println(questionSuperA_Class);
        System.out.println(a_Class);
    }
}
