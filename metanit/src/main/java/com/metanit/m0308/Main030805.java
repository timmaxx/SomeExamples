package com.metanit.m0308;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;

public class Main030805 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Пропорциональные размеры
        // Для столбцов с помощью метода setPercentWidth() можно установить,
        // сколько процентов общего пространства будет занимать данный столбец.
        // Аналогично для строк с помощью метода setPercentHeight() можно установить,
        // какую долю пространства контейнера будет занимать строка.
        // То есть вместо фиксированных размеров использовать пропорциональные:
        Label first = new Label("First");
        Label second = new Label("Second");
        Label third = new Label("Third");
        Label sixth = new Label("Sixth");

        GridPane root = new GridPane();
        // определения столбцов
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(30);
        root.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(40);
        root.getColumnConstraints().add(column2);

        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(30);
        root.getColumnConstraints().add(column3);

        // определения строк
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(55);
        root.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(45);
        root.getRowConstraints().add(row2);

        root.setGridLinesVisible(true);
        root.add(first, 0, 0);
        root.add(second, 1, 0);
        root.add(third, 2, 0);
        root.add(sixth, 2, 1);


        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);

        stage.setTitle("GridPane in JavaFX");

        stage.show();
        // Но если совокупная сумма процентов окажется больше 100, например, есть 3 столбца,
        // и для каждого из них установлена ширина в 50 процентов,
        // тогда каждый столбец будет занимать 1 / 3 пространства ( 50 / ( 50 + 50 + 50)).
    }
}
