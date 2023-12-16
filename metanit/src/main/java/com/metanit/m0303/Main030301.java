package com.metanit.m0303;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// https://metanit.com/java/javafx/3.3.php

public class Main030301 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label label1 = new Label("Label1");
        Label label2 = new Label("Label2");
        Label label3 = new Label("Label3");
        Label label4 = new Label("Label4");
        Label label5 = new Label("Label5");
        Label label6 = new Label("Label6");
        Label label7 = new Label("Label7");

        // Может показаться, что HBox ничем не отличается от FlowPane в горизонтальной ориентации.
        // Однако если вложенные элементы не умещаются по длине контейнера, то они не переносятся на новую строку,
        // а сжимаются, чтобы соответствовать по совокупности ширине контейнера.
        HBox root = new HBox(10, label1, label2, label3, label4, label5, label6, label7);
        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);

        stage.setTitle("HBox in JavaFX");

        stage.show();
    }

    /*
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
    */
}
