package timmax.example.rockscissorspaper;

public class HelloWorld {
    public static void main(String[] args) {
        Hand first = Hand.random();
        Hand second = Hand.random();

        System.out.printf("%s %s %s ", first, second, first.beats(second));
    }
}
