package com.metanit.m0407;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

import javafx.geometry.Orientation;

public class Main040701 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label lbl = new Label("Value");

        Slider slider = new Slider(0.0, 20.0, 10.0);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(2.0);
        slider.setMajorTickUnit(5.0);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);

        Button btn = new Button("Click");
        btn.setOnAction(event -> lbl.setText("Slider Value: " + slider.getValue()));

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, slider, lbl, btn);
        Scene scene = new Scene(root, 300, 250);

        stage.setScene(scene);
        stage.setTitle("Slider in JavaFX");
        stage.show();
    }
}