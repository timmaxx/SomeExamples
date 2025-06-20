package timmax.lambda.my.p01;

@FunctionalInterface
public interface I {
    void a();
}

/*
//  Не компилится, т.к. нет одного метода - их вообще нет.
@FunctionalInterface
public interface I {
}
*/

/*
//  Не компилится, т.к. нет одного метода - их два.
@FunctionalInterface
public interface I {
    void a();
    void b();
}
*/
