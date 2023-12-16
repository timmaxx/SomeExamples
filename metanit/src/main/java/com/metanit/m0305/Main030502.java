package com.metanit.m0305;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

// https://metanit.com/java/javafx/3.5.php

public class Main030502 extends Application {

    public static void main( String[ ] args) {
        Application.launch( args);
    }

    @Override
    public void start( Stage stage) {
        // С помощью метода setAlignment мы можем переопределить выравнивание по умолчанию:
        // В данном случае выравнивание всех элементов идет по центру исходя из того, к какой стороне контейнера они примыкают:
        Button left = new Button("Left");
        BorderPane.setAlignment(left, Pos.CENTER);

        Button right = new Button("Right");
        BorderPane.setAlignment(right, Pos.CENTER);

        Button top = new Button("Top");
        BorderPane.setAlignment(top, Pos.CENTER);

        Button bottom = new Button("Bottom");
        BorderPane.setAlignment(bottom, Pos.CENTER);

        Button center = new Button("Center");
        BorderPane root = new BorderPane(center, top, right, bottom, left);

        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);

        stage.setTitle("BorderPane in JavaFX");

        stage.show();
    }
}