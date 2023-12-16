package com.metanit.m0306;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main030601 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }


    @Override
    public void start(Stage stage) {
        // Создадим простейший StackPane:
        // По умолчанию элементы центрируются в контейнере.
        Label headerLbl = new Label("Press the login button");
        Label statusLbl = new Label("Start screen");
        Button loginBtn = new Button("Login");

        StackPane root = new StackPane(headerLbl, statusLbl, loginBtn);

        Scene scene = new Scene(root, 300, 150);
        stage.setScene(scene);

        stage.setTitle("StackPane in JavaFX");

        stage.show();
        // Поскольку кнопка добавляется последней, то она накладывается поверх остальных.
        // Однако вряд ли такой интерфейс можно считать оптимальным.
        // Поскольку нет смысла располагать кнопки и метки поверх друг друга.
    }
}
