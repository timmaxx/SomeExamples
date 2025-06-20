package timmax.lambda.my.p02;

public class Main02 {
    public static void main(String[] args) {
/*
        execute(new Runnable(
        ) {
            @Override
            public void run() {
                System.out.println("Hi");
            }
        }
        );
*/
        execute(
                () -> System.out.println("Hi")
        );
    }

    private static void execute(Runnable runnable) {
        System.out.println("start runner");
        runnable.run();
        System.out.println("end runner");
    }
}
