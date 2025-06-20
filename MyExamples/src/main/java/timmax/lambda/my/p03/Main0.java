package timmax.lambda.my.p03;

public class Main0 {
    public static void main(String[] args) {
/*
        execute(
                new I0() {
                    @Override
                    public void a() {
                        System.out.println("a");
                    }
                }
        );
*/

/*
        execute(
                () -> {
                    System.out.println("a");
                }
        );
*/

        execute(
                () -> System.out.println("a")
        );
    }

    private static void execute(I0 i0) {
        System.out.println("start runner");
        i0.a();
        System.out.println("end runner");
    }

}
