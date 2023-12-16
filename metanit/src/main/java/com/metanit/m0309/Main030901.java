package com.metanit.m0309;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;

public class Main030901 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Класс javafx.scene.layout.TilePane позволяет организовать вложенные элементы в виде тайлов.
        // Фактически тайлы представляют ячейки одинаковой высоты и ширины на пересечении строк и столбцов.
        // По умолчанию создается TilePane с горизонтальной ориентацией.
        // То есть все вложенные элементы размещаются в строку. Если места не хватает, то они переносятся на новую строку:
        Button first = new Button("First");
        Button second = new Button("Second");
        Button third = new Button("Third");
        Button fourth = new Button("Fourth");
        Button fifth = new Button("Fifth");
        Button sixth = new Button("Sixth");

        TilePane tilepane = new TilePane(first, second, third, fourth, fifth, sixth);

        Scene scene = new Scene(tilepane, 300, 200);
        stage.setScene(scene);

        stage.setTitle("TilePane in JavaFX");

        stage.show();
    }
}