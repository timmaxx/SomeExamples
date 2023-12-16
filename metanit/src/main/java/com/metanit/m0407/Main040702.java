package com.metanit.m0407;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;

import javafx.geometry.Orientation;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;

public class Main040702 extends Application {

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label lbl = new Label("Value");

        Slider slider = new Slider(0.0, 20.0, 10.0);

        // По умолчанию горизонтальный слайдер,
        // а так получится вертикальный.
        slider.setOrientation(Orientation.VERTICAL);

        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setBlockIncrement(2.0);
        slider.setMajorTickUnit(5.0);
        slider.setMinorTickCount(4);
        slider.setSnapToTicks(true);

        slider.valueProperty().addListener(new ChangeListener<Number>(){

            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                lbl.setText("Slider Value: " + newValue);
            }
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, slider, lbl);
        Scene scene = new Scene(root, 300, 150);

        stage.setScene(scene);
        stage.setTitle("Slider in JavaFX");
        stage.show();
    }
}