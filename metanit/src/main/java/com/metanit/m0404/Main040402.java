package com.metanit.m0404;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Orientation;
import javafx.geometry.Insets;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Main040402 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // И в этом случае более оптимальным решением является прослушивание изменений для всей группы в целом.
        // Для этого применяется интерфейс ChangeListener. Итак, изменим код программы следующим образом:
        Label selectedLbl = new Label();

        RadioButton javaBtn = new RadioButton("Java");
        RadioButton jsBtn = new RadioButton("JavaScript");
        RadioButton csharpBtn = new RadioButton("C#");

        ToggleGroup group = new ToggleGroup();
        // установка группы
        javaBtn.setToggleGroup(group);
        jsBtn.setToggleGroup(group);
        csharpBtn.setToggleGroup(group);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){

            public void changed(ObservableValue<? extends Toggle> changed, Toggle oldValue, Toggle newValue){

                // получаем выбранный элемент RadioButton
                RadioButton selectedBtn = (RadioButton) newValue;
                selectedLbl.setText("Selected: " + selectedBtn.getText());
            }
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(javaBtn, jsBtn, csharpBtn, selectedLbl);
        root.setPadding(new Insets(10));
        Scene scene = new Scene(root, 250, 200);

        stage.setScene(scene);
        stage.setTitle("RadioButtons in JavaFX");
        stage.show();
    }
}