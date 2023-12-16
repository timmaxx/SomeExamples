package com.metanit.m0303;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// https://metanit.com/java/javafx/3.3.php

public class Main030302 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Две кнопки вполне умещаются по ширине HBox, однако часть пространства контейнера остается не заполненным,
        // да и сами кнопки выглядят не очень хорошо:
        HBox hbox = new HBox();
        Button button1 = new Button("Add");
        Button button2 = new Button("Remove");
        hbox.getChildren().addAll(button1, button2);
        Scene scene = new Scene(hbox, 300, 150);
        stage.setScene(scene);

        stage.setTitle("HBox in JavaFX");

        stage.show();
    }
}
