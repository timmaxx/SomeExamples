package timmax.example.rockscissorspaper;

import java.util.Map;
import java.util.Random;
import java.util.Set;

public enum Hand {
    ROCK,
    SCISSOR,
    PAPER,
    WELL;

    // Кто кого бьёт:
    private static final Map<Hand, Set<Hand>> beatsMap = Map.of(
            ROCK, Set.of(SCISSOR), // Камень бьёт ножницы.
            SCISSOR, Set.of(PAPER),
            PAPER, Set.of(ROCK, WELL),
            WELL, Set.of(ROCK, SCISSOR)
    );

    private static final Random random = new Random();

    boolean beats(Hand other) {
        return beatsMap.get(this).contains(other);
    }

    static Hand random() {
        Hand[] options = Hand.values();
        int selected = random.nextInt(options.length);
        return options[selected];
    }
}
