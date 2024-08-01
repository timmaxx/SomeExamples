package javafx.timmax.p02;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainVBox extends VBox {
    Pane pane1 = new Pane01NoConnect();
    Pane pane2 = new Pane07GameMatchSelected();

    public MainVBox() {
        this.getChildren().addAll(pane1, pane2);
    }

    public Pane getPane1() {
        return pane1;
    }

    public Pane getPane2() {
        return pane2;
    }
}
