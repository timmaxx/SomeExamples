package com.metanit.m0306;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main030602 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage stage) {
        // Но с помощью статического метода setAlignment() можно определенным образом позиционировать вложенный элемент:
        // С помощью значения перечисления Pos StackPane может расположить элемент по каком-то определенном месте контейнера.
        Label headerLbl = new Label("Press the login button");
        StackPane.setAlignment(headerLbl, Pos.TOP_CENTER);
        Label statusLbl = new Label("Start screen");
        StackPane.setAlignment(statusLbl, Pos.BOTTOM_CENTER);
        Button loginBtn = new Button("Login");

        StackPane root = new StackPane(headerLbl, statusLbl, loginBtn);

        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);

        stage.setTitle("StackPane in JavaFX");

        stage.show();
    }

}
