package timmax.example.rockscissorspaper;

public abstract class Player {
    final String name;
    int score;
    Hand lastHand = null;

    public Player(String name) {
        this.name = name;
    }

    void reset() {
        score = 0;
        lastHand = null;
    }

    Hand drawHand() {
        lastHand = selectHand();
        return  lastHand;
    }

    protected abstract Hand selectHand();
}
