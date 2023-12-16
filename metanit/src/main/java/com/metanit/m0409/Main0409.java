package com.metanit.m0409;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;

// https://metanit.com/java/javafx/4.9.php

public class Main0409 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        langsComboBox.setValue("Java"); // устанавливаем выбранный элемент по умолчанию

        Label lbl = new Label();

        // получаем выбранный элемент
        langsComboBox.setOnAction(event -> lbl.setText(langsComboBox.getValue()));

        FlowPane root = new FlowPane(10, 10, langsComboBox, lbl);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("ComboBox in JavaFX");
        stage.show();
    }
}
