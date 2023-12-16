package com.metanit.m0410;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;

public class Main0410 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        ChoiceBox<String> langsChoiceBox = new ChoiceBox<String>(langs);
        langsChoiceBox.setValue("Java");

        Label lbl = new Label();
        langsChoiceBox.setOnAction(event -> lbl.setText(langsChoiceBox.getValue()));
        FlowPane root = new FlowPane(10, 10, langsChoiceBox, lbl);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("ChoiceBox in JavaFX");
        stage.show();
    }
}