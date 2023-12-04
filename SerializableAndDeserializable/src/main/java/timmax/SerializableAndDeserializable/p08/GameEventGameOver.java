package timmax.SerializableAndDeserializable.p08;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class GameEventGameOver extends GameEvent {
    private GameStatus gameStatus;


    public GameEventGameOver() {
    }

    public GameEventGameOver(
            GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(gameStatus);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        gameStatus = (GameStatus) in.readObject();
    }

    @Override
    public String toString() {
        return "GameEventGameOver{" +
                "gameStatus=" + gameStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // if (this == null) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameEventGameOver that = (GameEventGameOver) o;

        return gameStatus == that.gameStatus;
    }

    @Override
    public int hashCode() {
        return gameStatus.hashCode();
    }
}