package javafx.timmax.p02;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main03 extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Pane root = new MainVBox();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application");

        stage.show();
    }
}
