package com.metanit.m0107;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// https://metanit.com/java/javafx/1.7.php

public class Main extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Button btn = new Button();
        btn.setText("Click!");
        /*
        // Вариант с анонимным классом:
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.setText("You've clicked!");
            }
        });
        */
        // Вариант с лямбда-выражением:
        btn.setOnAction(e -> {
            btn.setText("You've clicked!");
        });

        Group root = new Group(btn);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("Hello JavaFX!");
        stage.setWidth(250);
        stage.setHeight(200);

        stage.show();
    }
}