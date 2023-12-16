package com.metanit.m0405;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.geometry.Orientation;

public class Main040501 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label lbl = new Label();
        TextField textField = new TextField();
        textField.setPrefColumnCount(11);
        Button btn = new Button("Click");
        btn.setOnAction(event -> lbl.setText("Input: " + textField.getText()));
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, textField, btn, lbl);
        Scene scene = new Scene(root, 250, 200);

        stage.setScene(scene);
        stage.setTitle("TextField in JavaFX");
        stage.show();
    }
}