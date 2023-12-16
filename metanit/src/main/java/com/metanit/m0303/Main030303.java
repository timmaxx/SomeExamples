package com.metanit.m0303;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

// https://metanit.com/java/javafx/3.3.php

public class Main030303 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Используем ограничение hgrow:
        // Для кнопок с помощью setMaxWidth задана максимальная ширина,
        // которая принимает максимально допустимое значение для типа double.
        // А в качестве ограничения для обеих кнопок задано значение Priority.ALWAYS,
        // которое указывает, что кнопки автоматически будут масштабироваться, чтобы заполнить пространство контейнера.
        HBox hbox = new HBox();
        Button button1 = new Button("Add");
        Button button2 = new Button("Remove");
        HBox.setHgrow(button1, Priority.ALWAYS);
        HBox.setHgrow(button2, Priority.ALWAYS);
        button1.setMaxWidth(Double.MAX_VALUE);
        button2.setMaxWidth(Double.MAX_VALUE);
        hbox.getChildren().addAll(button1, button2);
        Scene scene = new Scene(hbox, 300, 150);
        stage.setScene(scene);

        stage.setTitle("HBox in JavaFX");

        stage.show();
    }
}
