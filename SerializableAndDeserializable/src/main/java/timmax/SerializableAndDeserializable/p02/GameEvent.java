package timmax.SerializableAndDeserializable.p02;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

// В этом модуле применил аннотации Jackson.
// ToDo: Но лучше было-бы не использовать их (аннотации Jackson) здесь, а только в транспорте!
//       Но тогда там нужно в модулях транспорта использовать не аннотации, а вызовы методов.
//@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, property = "type")
// @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "class")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT, property = "@type")
@JsonSubTypes({
        @JsonSubTypes.Type(value= GameEventNewGame.class, name="GameEventNewGame")
})
public abstract class GameEvent {
}