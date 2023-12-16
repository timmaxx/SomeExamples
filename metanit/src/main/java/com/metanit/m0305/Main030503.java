package com.metanit.m0305;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

// https://metanit.com/java/javafx/3.5.php

public class Main030503 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Благодаря методам BorderPane нам необязательно определять элементы для центра, или для каждой из сторон.
        // Мы можем установить элементы только для тех сторон, которые действительно необходимы:
        BorderPane root = new BorderPane();

        Button top = new Button("Top");
        BorderPane.setAlignment(top, Pos.CENTER);
        root.setTop(top);

        Button center = new Button("Center");
        root.setCenter(center);

        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);

        stage.setTitle("BorderPane in JavaFX");

        stage.show();
    }
}