package com.metanit.m0408;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;

public class Main040804 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        TextField textField = new TextField();

        ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        ListView<String> langsListView = new ListView<String>(langs);
        langsListView.setPrefSize(250, 150);

        Button addBtn = new Button("Add");
        Button deleteBtn = new Button("Delete");
        FlowPane buttonPane = new FlowPane(10, 10, textField, addBtn, deleteBtn);

        addBtn.setOnAction(event -> langs.add(textField.getText()));
        deleteBtn.setOnAction(event -> langs.remove(textField.getText()));

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, buttonPane, langsListView);

        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("ListView in JavaFX");
        stage.show();
    }
}