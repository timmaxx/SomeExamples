package javafx.timmax.p02;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameClientPaneJfx extends VBox {

    public GameClientPaneJfx() {
        Pane viewJfx = new Pane();
        Button button = new Button("Some button");
        button.setPrefWidth(200);
        button.setMinWidth(200);
        viewJfx.getChildren().add(button);

        getChildren().add(viewJfx);
    }
}
