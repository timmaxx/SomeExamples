package timmax.SerializableAndDeserializable.p03;

import com.fasterxml.jackson.annotation.JsonCreator;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.PROPERTIES;

// В этом модуле применил аннотации Jackson.
// ToDo: Но лучше было-бы не использовать их (аннотации Jackson) здесь, а только в транспорте!
//       Но тогда там нужно в модулях транспорта использовать не аннотации, а вызовы методов.
public class GameEventNewGame extends GameEvent {
    private final int width;
    private final int height;


    @JsonCreator(mode = PROPERTIES)
    public GameEventNewGame(
            int width,
            int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}