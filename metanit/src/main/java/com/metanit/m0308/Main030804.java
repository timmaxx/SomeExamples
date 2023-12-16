package com.metanit.m0308;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class Main030804 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Чтобы растянуть строки по всей ширине GridPane,
        // нужно установить для них ограничение vgrow с помощью перечисления Priority и метода setVgrow():
        Label first = new Label("First");
        Label second = new Label("Second");
        Label third = new Label("Third");
        Label sixth = new Label("Sixth");

        GridPane root = new GridPane();
        // определения столбцов
        root.getColumnConstraints().add(new ColumnConstraints(80));
        ColumnConstraints column2 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        column2.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(column2);
        ColumnConstraints column3 = new ColumnConstraints(70, 70, Double.MAX_VALUE);
        column3.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(column3);

        // определения строк
        RowConstraints row1 = new RowConstraints(80, 80, Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);

        RowConstraints row2 = new RowConstraints(80, 80, Double.MAX_VALUE);
        row2.setVgrow(Priority.ALWAYS);

        root.getRowConstraints().add(row1);
        root.getRowConstraints().add(row2);

  /*
        root.getRowConstraints().add(new RowConstraints(80));
        root.getRowConstraints().add(new RowConstraints(80));
*/
        root.setGridLinesVisible(true);
        root.add(first, 0, 0);
        root.add(second, 1, 0);
        root.add(third, 2, 0);
        root.add(sixth, 2, 1);


        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);

        stage.setTitle("GridPane in JavaFX");

        stage.show();
    }
}