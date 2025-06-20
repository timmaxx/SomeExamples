package timmax.lambda.my.p05;

public class Main2 {
    public static void main(String[] args) {
/*
        execute(
            //  Полный вариант - без лямбды.
                new I2() {
                    @Override
                    public void a(int i, long l) {
                        System.out.println("a. i = " + i + ", l = " + l);
                    }
                },
                123,
                456l
        );
*/

/*
        execute(
                //  Лямбда полная.
                (int i, long l) -> {
                        System.out.println("a. i = " + i + ", l = " + l);
                    }
                ,
                123,
                456l
        );
*/


/*
        execute(
            //  Лямбда немного сокращённая за счёт того, что не указываем типы параметров.
            //      Тогда при перечислении аргументов слева от '->' можно не писать типы (внутри круглых скобок).
                (i, l) -> {
                        System.out.println("a. i = " + i + ", l = " + l);
                    }
                ,
                123,
                456l
        );
*/

        execute(
                //  Лямбда немного сокращённая за счёт того, что не указываем типы параметров.
                //      Тогда при перечислении аргументов слева от '->' можно не писать типы (внутри круглых скобок).
                (i, l) -> {
                    System.out.println("a. i = " + i + ", l = " + l);
                }
                ,
                123,
                456l
        );

/*
        execute(
            //  Лямбда немного сокращённая за счёт того, что метод имеет только одну строку (т.е. ';' один).
            //      Тогда блок кода, написанный справа от '->' можно написать без скобок (скобки фигурные) и без единственного ';'.
                (x) -> System.out.println("a. i = " + x),
                123
        );
*/
/*
        execute(
                //  Лямбда полностью сокращённая за счёт того, что оба предыдущих условия выполнены.
                x -> System.out.println("a. i = " + x),
                123
        );
*/
    }

    private static void execute(I2 i2, int ii, long ll) {
        System.out.println("start runner");
        i2.a(ii, ll);
        System.out.println("end runner");
    }
}
