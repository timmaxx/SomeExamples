package javafx.timmax.p02;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameClientPaneJfx extends VBox {
    public void createControls() {
        Pane viewJfx1 = new HBox();
        Button button11 = new Button("button11");
        button11.setPrefWidth(200);
        button11.setMinWidth(200);
        Button button12 = new Button("button12");
        button12.setPrefWidth(300);
        button12.setMinWidth(300);
        viewJfx1.getChildren().addAll(button11, button12);

        Pane viewJfx2 = new HBox();
        Button button21 = new Button("button21");
        button21.setPrefWidth(550);
        button21.setMinWidth(550);
        viewJfx2.getChildren().addAll(button21);

        getChildren().addAll(viewJfx1, viewJfx2);
    }
}
