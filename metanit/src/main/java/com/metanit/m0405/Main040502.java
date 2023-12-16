package com.metanit.m0405;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;

public class Main040502 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label lbl = new Label();
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(15);
        textArea.setPrefRowCount(5);
        Button btn = new Button("Click");
        btn.setOnAction(event -> lbl.setText("Input: " + textArea.getText()));
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, textArea, btn, lbl);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("TextArea in JavaFX");
        stage.show();
    }
}