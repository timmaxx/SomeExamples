package timmax.example.rockscissorspaper;

public class HelloWorld {
    public static void main(String[] args) {
        // Камень не бьёт бумагу. Должно быть false.
        System.out.println(Hand.ROCK.beats(Hand.PAPER));
    }
}
