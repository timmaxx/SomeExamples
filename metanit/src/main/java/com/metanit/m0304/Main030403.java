package com.metanit.m0304;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main030403 extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Подобным образом мы можем растягивать несколько элементов или комбинировать их с элементами,
        // которые не должны растягиваться:
        // Две кнопки будут заполнять равномерно пространство VBox, тогда как метка label занимает только то место,
        // которое ей необходимо.
        Button okBtn = new Button("OK");
        Button cancelBtn = new Button("Cancel");
        Label lbl = new Label("Select");

        VBox vbox = new VBox(15);

        VBox.setVgrow(okBtn, Priority.ALWAYS);
        okBtn.setMaxHeight(Double.MAX_VALUE);
        //okBtn.setMaxWidth(100);

        VBox.setVgrow(cancelBtn, Priority.ALWAYS);
        cancelBtn.setMaxHeight(Double.MAX_VALUE);
        //cancelBtn.setMaxWidth(100);

        vbox.getChildren().addAll(lbl, okBtn, cancelBtn);

        Scene scene = new Scene(vbox, 300, 150);
        stage.setScene(scene);

        stage.setTitle("VBox in JavaFX");

        stage.show();
        // Однако при использовании VBox, как видно из скриншота,
        // мы можем столкнуться с проблемой неравномерной ширины элементов.
        // Элементы автоматически не растягиваются по всей ширине контейнера.
    }
}