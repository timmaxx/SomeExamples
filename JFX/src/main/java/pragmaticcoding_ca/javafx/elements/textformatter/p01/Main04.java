package pragmaticcoding_ca.javafx.elements.textformatter.p01;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main04 extends Application {

    private ObjectProperty<Integer> valueProperty = new SimpleObjectProperty<>(0);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new TestPane(), 300, 100);
        valueProperty.addListener(((observable, oldValue, newValue) -> {
            System.out.println("Value changed -> Old Value: " + oldValue + ", New Value: " + newValue);
        }));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class TestPane extends BorderPane {
        public TestPane() {
            TextField textField = new TextField();
            TextFormatter<Integer> textFormatter = new TextFormatter(new PositiveIntegerStringConverter(), 0, new PositiveIntegerFilter());
            textFormatter.valueProperty().bindBidirectional(valueProperty);
            textField.setTextFormatter(textFormatter);
            setCenter(new VBox(10,
                    new HBox(6, new Text("TextField 1"), textField),
                    new HBox(6, new Text("TextField 2"), new TextField())));
        }
    }
}
