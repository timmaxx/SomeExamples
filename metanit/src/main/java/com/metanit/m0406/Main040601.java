package com.metanit.m0406;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;

import javafx.geometry.Orientation;

public class Main040601 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label headerLbl = new Label("ScrollPane");
        Label textLbl = new Label("Lorem Ipsum is simply dummy text of the printing and typesetting \n" +
                "industry. Lorem Ipsum has been the industry standard dummy \n" +
                "text ever since the 1500s, when an unknown printer took a galley...");

        ScrollPane scrollPane = new ScrollPane(textLbl);
        scrollPane.setPrefViewportHeight(150);
        scrollPane.setPrefViewportWidth(200);

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, headerLbl, scrollPane);
        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("ScrollPane in JavaFX");
        stage.show();
    }
}