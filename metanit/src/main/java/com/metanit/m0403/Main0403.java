package com.metanit.m0403;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;

public class Main0403 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        ToggleButton lightBtn = new ToggleButton("Light");
        Label stateLbl = new Label();
        // обработка нажатия
        lightBtn.setOnAction(event -> {

            if(lightBtn.isSelected()){
                stateLbl.setText("Light on!");
            }
            else{
                stateLbl.setText("Light off...");
            }
        });

        FlowPane root = new FlowPane(10, 10);
        root.getChildren().addAll(lightBtn, stateLbl);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 250, 200);

        stage.setScene(scene);

        stage.setTitle("Hello JavaFX");

        stage.show();
    }
}