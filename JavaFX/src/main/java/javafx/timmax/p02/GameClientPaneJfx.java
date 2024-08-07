package javafx.timmax.p02;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameClientPaneJfx extends VBox {

    public GameClientPaneJfx() {
        Pane viewJfx = new Pane();
        viewJfx.setPrefWidth(200);
        Button button = new Button();
        button.setPrefWidth(100);
        viewJfx.getChildren().add(button);

        getChildren().add(viewJfx);
    }
}
