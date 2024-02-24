package timmax.example.rockscissorspaper;

import java.util.Map;
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

    boolean beats(Hand other) {
        return beatsMap.get(this).contains(other);
    }
}
