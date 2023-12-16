package com.metanit.m0307;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Main0307 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Используем эти методы класса javafx.scene.layout.AnchorPane для настройки расположения кнопок:
        // Стоит отметить, что если мы будем растягивать или сжимать окно приложения,
        // то отступы останутся неизменными, а элементы также будут растягиваться и сжиматься соразмерно изменению окна.
        Button topBtn = new Button("Top");
        AnchorPane.setTopAnchor(topBtn, 10.0);
        AnchorPane.setLeftAnchor(topBtn, 60.0);
        AnchorPane.setRightAnchor(topBtn, 60.0);

        Button bottomBtn = new Button("Bottom");
        AnchorPane.setBottomAnchor(bottomBtn, 10.0);
        AnchorPane.setLeftAnchor(bottomBtn, 60.0);
        AnchorPane.setRightAnchor(bottomBtn, 60.0);

        Button leftBtn = new Button("Left");
        AnchorPane.setTopAnchor(leftBtn, 30.0);
        AnchorPane.setLeftAnchor(leftBtn, 15.0);
        AnchorPane.setBottomAnchor(leftBtn, 30.0);

        Button rightBtn = new Button("Right");
        AnchorPane.setTopAnchor(rightBtn, 30.0);
        AnchorPane.setRightAnchor(rightBtn, 10.0);
        AnchorPane.setBottomAnchor(rightBtn, 30.0);

        AnchorPane root = new AnchorPane(topBtn, rightBtn, bottomBtn, leftBtn);

        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);

        stage.setTitle("AnchorPane in JavaFX");

        stage.show();
    }
}
