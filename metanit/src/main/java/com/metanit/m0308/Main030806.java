package com.metanit.m0308;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class Main030806 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Позиционирование элементов
        // По умолчанию элементы занимают только то пространство, которое им необходимо:
        Button first = new Button("First");
        Button second = new Button("Second");
        Button third = new Button("Third");
        Button fourth = new Button("Fourth");

        GridPane root = new GridPane();

        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(50);
        root.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(50);
        root.getColumnConstraints().add(column2);

        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(50);
        root.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(50);
        root.getRowConstraints().add(row2);

        root.setGridLinesVisible(true);
        root.add(first, 0, 0);
        root.add(second, 0, 1);
        root.add(third, 1, 0);
        root.add(fourth, 1, 1);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);

        stage.setTitle("GridPane in JavaFX");

        stage.show();
        // Как мы видим, из скриншота, элементы позиционируются слева по горизонтали и по центру по вертикали.
    }
}
