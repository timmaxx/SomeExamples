package com.metanit.m0105;

import javafx.application.Application;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Main extends Application{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Label label = new Label("Hello");               // текстовая метка
        Button button = new Button("Button");           // кнопка
        Group group = new Group(button);                // вложенный узел Group

        FlowPane root = new FlowPane(label, group);       // корневой узел
        Scene scene = new Scene(root, 300, 150);        // создание Scene
        //Scene scene = new Scene(root, 400, 150, Color.BLUE);
        scene.setFill(Color.BLUE); // альтернативная установка цвета
        stage.setScene(scene);                          // установка Scene для Stage

        stage.setTitle("Hello JavaFX");

        stage.show();
    }
}