package com.metanit.m0302;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

// https://metanit.com/java/javafx/3.2.php

public class Main0302 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label label1 = new Label("Label1");
        Label label2 = new Label("Label2");
/*
        Label label3 = new Label("Label3");
        Label label4 = new Label("Label4");
        Label label5 = new Label("Label5");
        Label label6 = new Label("Label6");
        Label label7 = new Label("Label7");
        Label label8 = new Label("Label8");
        Label label9 = new Label("Label9");
*/
/*
        // По умолчанию элементы (в данном случае 9 меток Label) размещаются по горизонтали.
        // Отступы между элементами как по горизонтали, так и по вертикали составляют 10 единиц.
        //FlowPane root = new FlowPane(10, 10, label1, label2, label3, label4, label5, label6, label7, label8, label9);

        // Чтобы задать вертикальное направление элементов, необходимо использовать значение Orientation.VERTICAL.
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, label1, label2, label3, label4,
                label5, label6, label7, label8, label9);
*/
        FlowPane root = new FlowPane();
        root.setVgap(8);
        root.setHgap(15);
        root.setOrientation(Orientation.VERTICAL);
//      root.getChildren().addAll(label1, label2, label3, label4, label5, label6, label7, label8, label9);
        root.getChildren().addAll(label1, label2);
        root.setAlignment(Pos.CENTER);


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("FlowPane in JavaFX");
        stage.setWidth(300);
        stage.setHeight(200);

        stage.show();
    }
}