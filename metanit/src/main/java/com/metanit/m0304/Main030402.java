package com.metanit.m0304;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main030402 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Например, растянем кнопку по всей высоте контейнера:
        // Для кнопки с помощью setMaxHeight задается максимальная высота,
        // которая принимает максимально допустимое значение для типа double.
        // А в качестве ограничения устанавливается значение Priority.ALWAYS,
        // которое позволяет автоматически масштабировать кнопку, чтобы заполнить пространство контейнера.
        Button btn = new Button("Hello");
        VBox vbox = new VBox();
        VBox.setVgrow(btn, Priority.ALWAYS);
        btn.setMaxHeight(Double.MAX_VALUE);
        vbox.getChildren().addAll(btn);

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);

        stage.setTitle("VBox in JavaFX");

        stage.show();
    }
}