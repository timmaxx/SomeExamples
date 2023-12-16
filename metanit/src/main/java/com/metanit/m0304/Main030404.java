package com.metanit.m0304;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Main030404 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Чтобы выйти из этой проблемы, мы можем задать максимальную ширину для элементов:
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        Label lbl = new Label("Select");

        VBox vbox = new VBox(15);

        VBox.setVgrow(okBtn, Priority.ALWAYS);
        okBtn.setMaxHeight(Double.MAX_VALUE);
        okBtn.setMaxWidth(100); // !!!

        VBox.setVgrow(cancelBtn, Priority.ALWAYS);
        cancelBtn.setMaxHeight(Double.MAX_VALUE);
        cancelBtn.setMaxWidth(100); // !!!

        vbox.getChildren().addAll(lbl, okBtn, cancelBtn);

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);

        stage.setTitle("VBox in JavaFX");

        stage.show();
    }
}