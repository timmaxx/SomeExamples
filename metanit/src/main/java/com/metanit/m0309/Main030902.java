package com.metanit.m0309;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.geometry.Orientation;

public class Main030902 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Соответственно мы также можем задать вертикальную ориентацию:
        Button first = new Button("First");
        Button second = new Button("Second");
        Button third = new Button("Third");
        Button fourth = new Button("Fourth");
        Button fifth = new Button("Fifth");
        Button sixth = new Button("Sixth");

        TilePane tilepane = new TilePane(Orientation.VERTICAL, first, second, third, fourth, fifth, sixth);

        Scene scene = new Scene(tilepane, 300, 200);
        stage.setScene(scene);

        stage.setTitle("TilePane in JavaFX");

        stage.show();
    }
}