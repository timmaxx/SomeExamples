package com.metanit.m0102;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.List;

public class HelloApplication0102 extends Application {
    @Override
    public void init() throws Exception {
        System.out.println("Application inits.");
        super.init();
    }

    @Override
    public void start(Stage stage) {
        System.out.println("Application starts.");

        // получаем переданные параметры
        Application.Parameters params = getParameters();
        List<String> unnamedParams = getParameters().getUnnamed();
        if ( unnamedParams.isEmpty()) {
            System.out.println( "There are not command line parameters.");
        } else {
            int i = 0;
            for(String param: unnamedParams){
                i++;
                System.out.printf("%d - %s \n", i, param);
            }
        }

        Button btn = new Button();
        btn.setText("Click!");
        /*
        // Вариант с анонимным классом:
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn.setText("You've clicked!");
            }
        });
        */
        // Вариант с лямбда-выражением:
        btn.setOnAction( e -> {
            btn.setText( "You've clicked!");
        });


        // установка надписи
        Text text = new Text("Hello METANIT.COM!");
        text.setLayoutY(80);   // установка положения надписи по оси Y.
        text.setLayoutX(80);   // установка положения надписи по оси X.

        Group group = new Group( btn, text);

        Scene scene = new Scene( group, 600, 250, Color.RED);
        // scene.setFill( Color.BLUE);
        stage.setScene(scene);
        stage.setTitle("JavaFX Application.");
        stage.setWidth(300);
        stage.setHeight(250);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Application stops");
        super.stop();
    }

    public static void main(String[] args) {
        System.out.println("Launching Application");
        launch();
    }
}