package com.metanit.m0404;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;

// https://metanit.com/java/javafx/4.4.php

public class Main040401 extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // Здесь все радиокнопки помещаются в одну группу,
        // соответственно мы можем выбрать только одну радиокнопку в рамках этой группы:
        Label selectedLbl = new Label();

        RadioButton javaBtn = new RadioButton("Java");
        RadioButton jsBtn = new RadioButton("JavaScript");
        RadioButton csharpBtn = new RadioButton("C#");

        ToggleGroup group = new ToggleGroup();
        // установка группы
        javaBtn.setToggleGroup(group);
        jsBtn.setToggleGroup(group);
        csharpBtn.setToggleGroup(group);

        // установка обработчика события нажатия
        javaBtn.setOnAction(event -> selectedLbl.setText("Selected: Java"));
        jsBtn.setOnAction(event -> selectedLbl.setText("Selected: JavaScript"));
        csharpBtn.setOnAction(event -> selectedLbl.setText("Selected: C#"));

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(javaBtn, jsBtn, csharpBtn, selectedLbl);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 250, 200);

        stage.setScene(scene);
        stage.setTitle("RadioButtons in JavaFX");
        stage.show();
        // Хотя пример выше работает, но в нем есть одна проблема:
        // мы вынуждены устанавливать обработчик для каждой кнопки,
        // код которого повторяется и меняется только передаваемый текст.
        // Если кнопок десять, соответственно потребуется прикрепить десять обработчиков.
        // А если мы потом захотим изменить логику обработчиков, то потребуется изменить все 10 обработчиков.
    }
}